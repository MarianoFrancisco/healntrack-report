package com.sa.healntrack.report_service.room.infrastructure.adapter.out.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sa.healntrack.report_service.room.application.port.out.persistence.ExistsRoomById;
import com.sa.healntrack.report_service.room.application.port.out.persistence.ExistsRoomByNumber;
import com.sa.healntrack.report_service.room.application.port.out.persistence.ExistsRoomByNumberAndIdNot;
import com.sa.healntrack.report_service.room.application.port.out.persistence.FindRoomById;
import com.sa.healntrack.report_service.room.application.port.out.persistence.SaveRoom;
import com.sa.healntrack.report_service.room.domain.Room;
import com.sa.healntrack.report_service.room.infrastructure.adapter.out.persistence.entity.RoomEntity;
import com.sa.healntrack.report_service.room.infrastructure.adapter.out.persistence.mapper.RoomPersistenceMapper;
import com.sa.healntrack.report_service.room.infrastructure.adapter.out.persistence.repository.RoomEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class RoomRepository implements SaveRoom, FindRoomById, ExistsRoomByNumber, ExistsRoomByNumberAndIdNot, ExistsRoomById {

    private final RoomPersistenceMapper mapper;
    private final RoomEntityRepository repository;

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Room save(Room room) {
        RoomEntity entity = repository.save(mapper.fromDomain(room));
        return mapper.toDomain(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Room> findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsByNumber(String number) {
        return repository.existsByNumber(number);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsByNumberAndIdNot(String number, UUID id) {
        return repository.existsByNumberAndIdNot(number, id);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }
    
}
