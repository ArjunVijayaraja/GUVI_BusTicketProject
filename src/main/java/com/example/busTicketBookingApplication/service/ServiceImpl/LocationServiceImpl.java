package com.example.busTicketBookingApplication.service.ServiceImpl;

import com.example.busTicketBookingApplication.entity.Locations;
import com.example.busTicketBookingApplication.repository.LocationRepository;
import com.example.busTicketBookingApplication.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;
    @Override
    public List<Locations> getAllLocation() {
        ;

        return locationRepository.findAll() ;
    }
}
