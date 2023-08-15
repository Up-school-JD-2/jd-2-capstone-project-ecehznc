package io.upschool;


import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.upschool.dto.AirlineSaveRequest;
import io.upschool.dto.AirportSaveRequest;
import io.upschool.dto.route.RouteSaveRequest;
import io.upschool.entity.CreditCard;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class CapstoneProjectApplication {

    public static void main(String[] args) {
    	
    	
        SpringApplication.run(CapstoneProjectApplication.class, args);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        

        while (!exit) {
            System.out.println("1. Havayolu şirketi ekleme");
            System.out.println("2. Havaalanı ekleme");
            System.out.println("3. Rota ekleme");
            System.out.println("4. Bilet satın alma");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminizi yapın: ");

            int choice = scanner.nextInt();

            switch (choice) {
            
                case 1:
                	System.out.println("Havayolu şirketi adını girin:");
                    String airlineName = scanner.next();

                    System.out.println("Havayolu şirketi için havaalanı id'sini girin:");
                    Long airportId = scanner.nextLong();                    

                    AirlineSaveRequest airlineSaveRequest = new AirlineSaveRequest();
                    airlineSaveRequest.setName(airlineName);
                    airlineSaveRequest.setAirportId(airportId);
                    break;
                case 2:
                	System.out.println("Havaalanı adı: ");
                    String airportName = scanner.nextLine();
                    
                    System.out.println("Havaalanı kodu: ");
                    String airportCode = scanner.nextLine();
                    
                    AirportSaveRequest request = new AirportSaveRequest();
                    request.setName(airportName);
                    request.setCode(airportCode);
                                     
                case 3:
                	System.out.println("Başlangıç Rota Adı: ");
                    String sourceAirportCode = scanner.nextLine();
                    
                    System.out.println("Varış Rotas Adı: ");
                    String destinationAirportCode = scanner.nextLine();
                    
                    RouteSaveRequest routeSaveRequest = new RouteSaveRequest();
                    routeSaveRequest.setSourceAirportCode(sourceAirportCode);
                    routeSaveRequest.setDestinationAirportCode(destinationAirportCode);
                    
                    break;
                case 4:
                	CreditCard creditCard = new CreditCard();
                    System.out.print("Kredi kartı numarası girin: ");
                    String cardNumber = scanner.nextLine();
                    creditCard.setCardNumber(cardNumber);

                    System.out.println("Bilet satın alma işlemi başarıyla tamamlandı. Bilet numarası: " );
                
                    break;
                case 5:
                    exit = true;
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                    break;
            }
        }

        scanner.close();
    }
 }


