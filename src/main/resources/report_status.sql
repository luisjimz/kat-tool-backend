INSERT INTO public.report_status (code,description,hex_color,status_name) VALUES
	 (0,'En espera de documentos por parte del cliente','#84cc16','WAITING_DOCUMENTS'),
	 (1,'En contabilizacion','#84cc16','UNDER_ACCOUNTING'),
	 (2,'Bajo revision de supervisor','#84cc16','UNDER_REVIEW'),
	 (3,'Pendiente de enviar carta de impuestos','#84cc16','PENDING_SEND_TAX_LETTER'),
	 (4,'Pendiente de enviar carta de impuestos','#84cc16','PENDING_APPROVAL'),
	 (5,'Carta de impuestos enviada','#84cc16','PENDING_SEND_STATEMENT'),
	 (6,'Carta de impuestos enviada','#84cc16','STATEMENT_SENT'),
	 (100,'Servicio terminado','#84cc16','DONE');
