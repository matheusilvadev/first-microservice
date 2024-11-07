package com.astrocode.email_mcs.dtos;

import java.util.UUID;

public record EmailRecordDTO(UUID userId,
                             String emailTo,
                             String title,
                             String text) {
}
