; ========================================================================================
; | Modulname:   main.s                                   | Prozessor:  STM32G474        |
; |--------------------------------------------------------------------------------------|
; | Ersteller:   Peter Raab                               | Datum:  03.09.2021           |
; |--------------------------------------------------------------------------------------|
; | Version:     V1.0            | Projekt:               | Assembler:  ARM-ASM          |
; |--------------------------------------------------------------------------------------|
; | Aufgabe:     Basisprojekt                                                            |
; |                                                                                      |
; |                                                                                      |
; |--------------------------------------------------------------------------------------|
; | Bemerkungen:                                                                         |
; |                                                                                      |
; |                                                                                      |
; |--------------------------------------------------------------------------------------|
; | Aenderungen:                                                                         |
; |     03.09.2021     Peter Raab        Initial version                                 |
; |                                                                                      |
; ========================================================================================

; ------------------------------- includierte Dateien ------------------------------------
    INCLUDE STM32G4xx_REG_ASM.inc

; ------------------------------- exportierte Variablen ------------------------------------


; ------------------------------- importierte Variablen ------------------------------------		
		

; ------------------------------- exportierte Funktionen -----------------------------------		
	EXPORT  main
	
; ------------------------------- importierte Funktionen -----------------------------------
	;zeitschleife, R0 - parameter, millisekunden
	AREA 	updelay, code, readonly 
	EXPORT TIM6_IRQHandler
TIM6_IRQHandler PROC 
	LDR R0, =TIM6_SR ;Interrupt Request zurücksetzen
	LDR R1, =0
	STR R1, [R0]
	
	;counter zählen
	LDR R0, =timer_counter
	LDR R1, [R0]
	ADD R1, #1
	STR R1, [R0]
	CMP R1, #100
	BNE ende
	
	;counter zurücksetzen
	LDR R1, =0
	STR R1, [R0]
	


ende
	BX LR
	ENDP	
		
up_delay
	LDR R1, =4000
	MUL R0, R0, R1
	ALIGN 4
timeloop_p0
	SUB R0, #1
	CMP R0, #0
	BNE timeloop_p0
	BX LR
	
	
	;zifferausgabe, R0 - ziffer 0-9, R1 - 7-segmentanzeige auswahl, 0: rechts, 1: links
	AREA uppdisplay, CODE, readonly
		
up_display
	LDR	R2, =leds
	LDRB R2, [R2, R0]
	
	CMP R1, #0
	BEQ writedisplay
	ADD R2, R2, #128

writedisplay
	LDR R3, =GPIOA_ODR
	STR R2, [R3]
	BX LR
	
	;Abfrage der Buttons
	AREA buttonreq_, CODE, readonly
buttonreq
	LDR R3, =GPIOC_IDR 
	;P0 (Start button)
	LDR R4, [R3]
	AND R4, R4, #1
	CMP R4, #0
	BEQ start
	
	;P1 (Stop Button)
	LDR R4, [R3]
	AND R4, R4, #2
	CMP R4, #0
	BEQ stop
	
	;P2 (Reset Button)	
	CMP R11, #0			
	BNE return			
	LDR R4, [R3]		
	AND R4, R4, #4		
	CMP R4, #0			
	BEQ reset			 
	
	BX LR
	
start
	LDR R11, =1
	BX LR
stop
	LDR R11, =0
	BX LR
reset
	LDR R5, =0
	LDR R6, =0
	BX LR
return 
	BX LR
	
; ------------------------------- symbolische Konstanten ------------------------------------


; ------------------------------ Datensection / Variablen -----------------------------------

	AREA array, DATA, readonly
leds DCB 0x3f, 0x06, 0x5b, 0x4f, 0x66, 0x6d, 0x7d, 0x07, 0x7f, 0x67

	AREA glvar, DATA, readwrite
timer_counter SPACE 4
timer_state SPACE 4 ;Speichert den State des Timers (0 = stopped, 1 = running)


; ------------------------------- Codesection / Programm ------------------------------------
	AREA	main_s,code
	

	

			
; -----------------------------------  Einsprungpunkt - --------------------------------------

main PROC

    ; Initialisierungen
		
	
	;Takt von GPIOA und C anschalten
	LDR R0, =RCC_AHB2ENR
	LDR R1, =5
	STR R1, [R0]
   
    ;Mode der unteren 8 Pins von GPIOA auf Output setzen
	LDR R0, =GPIOA_MODER 
	LDR R1, [R0]
	LDR R2, =0xFFFF0000 	;Maskierung der unteren Pins
	AND R1, R1, R2
	LDR R2, =0x00005555
	ORR R1, R1, R2
	STR R1, [R0]
	
	;LEDs ausschalten
	LDR R0, =GPIOA_ODR
	LDR R1, =0x00
	STR R1, [R0]
	
	;Pins 0, 1, 2 von GPIOC als Input konfigurieren
	LDR R3, =GPIOC_MODER
	LDR R1, [R3]
	LDR R2, =0xFFFFFFC0 ;letzte 6 Bits auf 0 setzen
	AND R1, R1, R2
	STR R1, [R3]

	;Globale Variablen init
	LDR R0, =timer_counter
	LDR R1, =0
	STR R1, [R0]
	
	LDR R0, =timer_state
	LDR R1, =0
	STR R1, [R0]
	
	;Konfiguration Timer 6
	LDR R0, =RCC_APB1ENR1 ;Timer 6 aktivieren
	LDR R1, =0x10
	STR R1, [R0]
	
	LDR R0, =TIM6_PSC ;Prescaler setzen
	LDR R1, =15999
	STR R1, [R0]
	
	LDR R0, =TIM6_ARR ;Dauer setzen
	LDR R1, =99
	STR R1, [R0]
	
	LDR R0, =TIM6_CR1 ;Counter und Update Event aktivieren
	LDR R1, [R0]
	ORR R1, R1, #0x1
	STR R1, [R0]
	
	LDR R0, =NVIC_ICPR1 ;Pending bit zurücksetzen	
	MOV R1, #(1<<22)								
	STR R1, [R0]									 
	
	LDR R0, =NVIC_ISER1 ;Timer 6 Interrupt im NVIC aktivieren (IRQ54)
	MOV R1, #(1<<22)
	STR R1, [R0]
	
	LDR R0, =TIM6_DIER ;Counter und Update Event aktivieren
	LDR R1, =1
	STR R1, [R0]
	
;main loop
loop	
	
	;rechtes Digit anzeigen
	LDR R5, =timer_counter
	LDR R0, [R5]
	MOV R3, #10
	UDIV R2, R0, R3 ;modulo ausrechnen
	MUL R2, R2, R3
	SUB R0, R0, R2
	LDR R1, =0
	BL up_display
	LDR R0, =10
	BL up_delay
	;BL buttonreq 
	
	;linkes Digit anzeigen
	LDR R6, =timer_counter
	LDR R0, [R6]
	MOV R3, #10
	UDIV R0, R0, R3
	LDR R1, =1
	BL up_display
	LDR R0, =10
	BL up_delay
	;BL buttonreq
	
	
	B	loop	
  
	ENDP

	END
		