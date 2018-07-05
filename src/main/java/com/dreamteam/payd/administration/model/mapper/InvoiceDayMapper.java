package com.dreamteam.payd.administration.model.mapper;

import com.dreamteam.payd.administration.api.portal.DTO.InvoiceDTO;
import com.dreamteam.payd.administration.api.portal.DTO.InvoiceDayDTO;
import com.dreamteam.payd.administration.model.Day;
import com.dreamteam.payd.administration.util.BaseMapperUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by loci on 4-6-17.
 */
public class InvoiceDayMapper {

    public List<InvoiceDayDTO> to(List<Day> days) {
        List<InvoiceDayDTO> dtos = new ArrayList<>();
        days.forEach(d -> /*using the d*/{
            InvoiceDayDTO dto = new InvoiceDayDTO(d.getId(), d.getDayDate(), d.getTotalPrice().longValue(), d.getDistance());
            dtos.add(dto);
        });

        return dtos;
    }
}
