package com.example.msadminventaskafka.controller;

import com.example.msadminventaskafka.dto.VentaDTO;
import com.example.msadminventaskafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping
    public String registrarVenta(@RequestBody VentaDTO venta) {
        producerService.enviarVenta(venta);
        return "Venta enviada a Kafka correctamente: " + venta.toString();
    }
}
