package org.example.Service.src.main.java.ru.platik777.service.services;

import org.FitBot.DTO.TrackDTO;
import org.FitBot.DtoTrackInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.FitBot.entities.Track;
import org.example.Service.src.main.java.ru.platik777.service.repositories.TrackRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public List<TrackDTO> getTracks() {
        return trackRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<TrackDTO> getTrackById(Long id) {
        return trackRepository.findById(id)
                .map(this::convertToDTO);
    }

    public TrackDTO saveTrack(DtoTrackInfo trackDto) {
        Track track = convertToEntity(trackDto);
        Track savedTrack = trackRepository.save(track);
        return convertToDTO(savedTrack);
    }

    public void deleteTrack(Long id) {
        trackRepository.deleteById(id);
    }

    public Track findByAverageHeartRateAndAndAverageSpeedAndTrackDistance(int distance, int speed, int heartRate) {
        Optional<Track> trackOptional = trackRepository.findByAverageHeartRateAndAndAverageSpeedAndTrackDistance(heartRate, speed, distance);
        return trackOptional.orElse(null);
    }

    private TrackDTO convertToDTO(Track track) {
        TrackDTO trackDto = new TrackDTO();
        trackDto.setId(track.getId());
        trackDto.setAverageSpeed(track.getAverageSpeed());
        trackDto.setAverageHeartRate(track.getAverageHeartRate());
        trackDto.setTrackDistance(track.getTrackDistance());
        return trackDto;
    }

    private Track convertToEntity(TrackDTO trackDto) {
        Track track = new Track();
        //track.setId(trackDto.getId());
        track.setAverageSpeed(trackDto.getAverageSpeed());
        track.setAverageHeartRate(trackDto.getAverageHeartRate());
        track.setTrackDistance(trackDto.getTrackDistance());
        return track;
    }
}
