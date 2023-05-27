package com.projetopm.veterinaria.controller;


import com.projetopm.veterinaria.model.entities.Consulta;
import com.projetopm.veterinaria.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping("/{id}/{email}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Consulta solicitarConsulta(@RequestParam("date") String dateString,
                                      @RequestParam("time") String timeString, @PathVariable Integer id,
                                      @PathVariable String email ) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        Date date;
        Date time;

        date = dateFormat.parse(dateString);
        time = timeFormat.parse(timeString);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, time.getHours());
        calendar.set(Calendar.MINUTE, time.getMinutes());

        Consulta consulta = new Consulta();
        consulta.setData(calendar);

        return service.solicitarConsulta(consulta, id, email);
    }



}
