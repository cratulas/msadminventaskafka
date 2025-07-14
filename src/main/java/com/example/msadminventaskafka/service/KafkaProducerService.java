package com.example.msadminventaskafka.service;

import com.example.msadminventaskafka.dto.VentaDTO;

public interface KafkaProducerService {
    void enviarVenta(VentaDTO venta);
}
