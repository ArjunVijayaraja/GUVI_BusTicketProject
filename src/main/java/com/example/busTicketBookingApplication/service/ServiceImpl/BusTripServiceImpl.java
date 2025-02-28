package com.example.busTicketBookingApplication.service.ServiceImpl;

import com.example.busTicketBookingApplication.dto.BusTripDto;
import com.example.busTicketBookingApplication.dto.SeatDetailsDto;
import com.example.busTicketBookingApplication.entity.BusTrip;
import com.example.busTicketBookingApplication.entity.SeatDetails;
import com.example.busTicketBookingApplication.exception.DuplicateTripException;
import com.example.busTicketBookingApplication.repository.BusTripRepository;
import com.example.busTicketBookingApplication.repository.SeatDetailsRepository;
import com.example.busTicketBookingApplication.service.BusTripService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BusTripServiceImpl implements BusTripService {

    private BusTripRepository busTripRepository;
    private SeatDetailsRepository seatDetailsRepository;
    private ModelMapper modelMapper;


    @Override
    public BusTripDto createBus(BusTripDto busTripDto) {
       Optional<BusTrip> optionalBusTrip =  busTripRepository.findByBusRegistrationNumberAndTripDate(busTripDto.getBusRegistrationNumber(),
                busTripDto.getTripDate());
       if(optionalBusTrip.isPresent()){
           throw new DuplicateTripException(busTripDto.getFromLocation(),busTripDto.getToLocation(),busTripDto.getBusRegistrationNumber(),busTripDto.getTripDate());
       }
       else{
           BusTrip busTrip = new BusTrip();
           busTrip.setBusTravelName(busTripDto.getBusTravelName());
           busTrip.setBusRegistrationNumber(busTripDto.getBusRegistrationNumber());
           busTrip.setTripDate(busTripDto.getTripDate());
           busTrip.setFromLocation(busTripDto.getFromLocation());
           busTrip.setToLocation(busTripDto.getToLocation());
           busTrip.setDepartureTime(busTripDto.getDepartureTime());
           busTrip.setArrivalTime(busTripDto.getArrivalTime());
           busTrip.setTicketPrice(busTripDto.getTicketPrice());
           List<SeatDetails> seatDetails = busTripDto.getSeatDetails().stream()
                   .map(i->modelMapper.map(i,SeatDetails.class)).collect(Collectors.toList());
           busTrip.setSeatDetails(seatDetails);

           BusTrip savedBusTrip = busTripRepository.save(busTrip);
           savedBusTrip.getSeatDetails().stream().forEach(
                   i->{
                       i.setBusTrip(savedBusTrip);
                       seatDetailsRepository.save(i);
                   });
           return modelMapper.map(savedBusTrip,BusTripDto.class);
       }

    }


    @Override
    public List<BusTripDto> getAllBus() {
        List<BusTrip> busList = busTripRepository.findAll();
        List<BusTripDto> busTripDtoList = busList.stream().map(
                i-> modelMapper.map(i,BusTripDto.class))
                .collect(Collectors.toList());
        return busTripDtoList;

    }

    public List<SeatDetailsDto> getAvailableTripSeats(long busTripId){
       List<SeatDetails> tripSeatDetails = seatDetailsRepository.findByBusTrip_BusTripId(busTripId);
       List<SeatDetailsDto> tripSeatDetailsDto = tripSeatDetails.stream().map(i->modelMapper.map(i,SeatDetailsDto.class)).collect(Collectors.toList());
       return tripSeatDetailsDto;


    }

    @Override
    public BusTripDto findByBusId(long id) {
        BusTrip  busTrip = busTripRepository.findById(id).get();

        return  modelMapper.map(busTrip,BusTripDto.class);
    }

    @Override
    public List<BusTripDto> findBusByRoute(BusTripDto busTripDto) {
       List<BusTrip> busTriplist =  busTripRepository.findByFromLocationAndToLocationAndTripDate(busTripDto.getFromLocation(),busTripDto.getToLocation(),busTripDto.getTripDate());
       return
               busTriplist.stream().map(i->modelMapper.map(i,BusTripDto.class))
                       .collect(Collectors.toList());
    }

    @Override
    public BusTripDto createBusTrip(BusTripDto busTripDto) {
        busTripDto.setTripStatus("Live");
        Optional<BusTrip> optionalTrip = busTripRepository.findByBusRegistrationNumberAndTripDateAndTripStatus(busTripDto.getBusRegistrationNumber(),
                busTripDto.getTripDate(),busTripDto.getTripStatus());
        if(optionalTrip.isPresent()){
            throw new RuntimeException("Trim ALready exists");
        }
        else{
            BusTrip busTrip = modelMapper.map(busTripDto,BusTrip.class);
            BusTrip savedBusTrip = busTripRepository.save(busTrip);

            savedBusTrip.getSeatDetails().stream().forEach(
                    i->{
                        i.setBusTrip(savedBusTrip);
                        seatDetailsRepository.save(i);
                    });

            return modelMapper.map(savedBusTrip,BusTripDto.class);
        }
    }

}
