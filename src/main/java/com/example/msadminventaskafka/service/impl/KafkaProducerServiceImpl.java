package com.example.msadminventaskafka.service.impl;

import com.example.msadminventaskafka.config.KafkaProducerConfig;
import com.example.msadminventaskafka.dto.VentaDTO;
import com.example.msadminventaskafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, VentaDTO> kafkaTemplate;

    @Override
    public void enviarVenta(VentaDTO venta) {
        venta.setFecha(Instant.now().toString());
        kafkaTemplate.send(KafkaProducerConfig.TOPIC_VENTAS, venta);
    }
}
