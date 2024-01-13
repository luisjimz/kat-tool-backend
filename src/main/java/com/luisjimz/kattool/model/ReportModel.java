package com.luisjimz.kattool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportModel{

    private Long id;
    private ReportTypeModel reportType;
    private ClientModel client;
    private UserModel assignedUser;
    private String reportStatus;

    //todo hacer una tabla con llave compuesta para guardar Status de Reporte por tipo de reporte

    /*
    * IMSS
    *   Altas/bajas - Actualizaciones del IMSS (mensual)
    *   Calculo del pago del IMSS (mensual)
    *
    * IMPUESTOS
    *   Calculo del pago de impuestos:
            WAITING_DOCUMENTS = 'En espera de documentacion',
            UNDER_ACCOUNTING = 'En contabilizacion',
            UNDER_REVIEW = 'En revision',
            PENDING_SEND_TAX_LETTER = 'En espera de enviar carta de impuestos',
            PENDING_APPROVAL = 'En aprobacion',
            PENDING_SEND_STATEMENT = 'Pendiente declaración',
            STATEMENT_SENT = 'Declaracion enviada',
            DONE = 'Cuenta cerrada',
            UNKNOWN_STATUS = 'Contact support'
    *
    * NOMINAS
    *   Calculo del pago de nomina VoBo cliente.
    *       Recepcion de informacion
    *           Modificacion de nominas ~
    *       Envio de reporte de nomina al cliente.
    *       Visto bueno cliente.
    *       Emision de factura a clientes.
    *
     */

}
