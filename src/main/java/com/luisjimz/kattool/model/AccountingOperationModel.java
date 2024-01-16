package com.luisjimz.kattool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountingOperationModel {

    private Long id;
    private AccountingOperationTypeModel accountingOperationType;
    private AccountingOperationStatusModel latestStatus;
    private Date creationDate;

    //todo hacer una tabla con llave compuesta para guardar Status de Reporte por tipo de reporte

    /*
    * IMSS
    *   Altas/bajas - Actualizaciones del IMSS (mensual)
    *   Calculo del pago del IMSS (mensual)
    *
    * IMPUESTOS FEDERALES
                WAITING_DOCUMENTS = 'En espera de documentacion',
                UNDER_ACCOUNTING = 'En contabilizacion',
                UNDER_REVIEW = 'En revision',
                PENDING_SEND_TAX_LETTER = 'En espera de enviar carta de impuestos',
                PENDING_APPROVAL = 'En aprobacion',
                PENDING_SEND_STATEMENT = 'Pendiente declaración',
                STATEMENT_SENT = 'Declaracion enviada',
                DONE = 'Cuenta cerrada',
                UNKNOWN_STATUS = 'Contact support'
    * IMPUESTOS ESTATALES
                GENERAR DECLARACION
                DECLARACION ENVIADA
                PENDIENTE DE PAGO
                PAGADO
    * NOMINAS
    *   Calculo del pago de nomina VoBo cliente.
                UNDER_ACCOUNTING = 'En contabilizacion',

    *           Modificacion de nominas ~
    *       Envio de reporte de nomina al cliente.
    *       Visto bueno cliente.
    *       Emision de factura a clientes.
    *
     */

}
