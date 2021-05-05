package javaGameCenterProject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javaGameCenterProject.Abstract.BaseUserManager;
import javaGameCenterProject.Adapters.MernisServiceAdapter;
import javaGameCenterProject.Adapters.TCKNValidatation;
import javaGameCenterProject.Adapters.UserValidation;
import javaGameCenterProject.Concrete.CampaignManager;
import javaGameCenterProject.Concrete.GameManager;
import javaGameCenterProject.Concrete.GamerManager;
import javaGameCenterProject.Concrete.OrderManager;
import javaGameCenterProject.Concrete.ServiceFactoryManager;
import javaGameCenterProject.Data.Concrete.CampaignDbManager;
import javaGameCenterProject.Data.Concrete.GameDbManager;
import javaGameCenterProject.Data.Concrete.GamerDbManager;
import javaGameCenterProject.Data.Concrete.OrderDbManager;
import javaGameCenterProject.Data.Concrete.UserDbManager;
import javaGameCenterProject.Entities.Campaign;
import javaGameCenterProject.Entities.Cart;
import javaGameCenterProject.Entities.Game;
import javaGameCenterProject.Entities.Gamer;
import javaGameCenterProject.Entities.OrderDetail;
import javaGameCenterProject.Entities.User;

public class Main {
		
	public static void main(String[] args) {
		//Sistem ba�lat�l�yor
		System.out.println("\n\n========================= Java Camp Game Store =========================\n");
		
		//Startup settings - ServiceFactory denemesi
		ServiceFactoryManager serviceFactoryManager = new ServiceFactoryManager();
		serviceFactoryManager.release(new CampaignDbManager());
		serviceFactoryManager.release(new GameDbManager());
		serviceFactoryManager.release(new GamerDbManager());
		serviceFactoryManager.release(new OrderDbManager());
		serviceFactoryManager.release(new UserDbManager());
		serviceFactoryManager.release(new MernisServiceAdapter());
		serviceFactoryManager.release(new GameManager(serviceFactoryManager));
		serviceFactoryManager.release(new CampaignManager(serviceFactoryManager));
		
		//Add game
		Game game = new Game(1, "U�an Kodcular Java Edition", "v1.0", LocalDate.now(),25.0,35);
		GameManager gameManager = new GameManager(serviceFactoryManager);
		gameManager.add(game);
		
		//Add campaign
		Campaign campaign = new Campaign("Csharp��dan Javac�ya Zeytin Dal�", LocalDate.now(), LocalDate.of(2021, 8, 30), "Java Geli�tiricilerine Csharp�� masas�ndan indirim taba��", 0.3);
		CampaignManager campaignManager = new CampaignManager(serviceFactoryManager);
		campaignManager.add(campaign);
		
		//Add gamer
		Gamer gamer1 = new Gamer(
				LocalDate.now(),
				"barisertugrul@barisertugrul.com",
				"12345",
        		"Bar��",
        		"Ertu�rul",
        		"12345678910",
        		LocalDate.of(1977, 01, 01)
        		);
        

        Gamer gamer2 = new Gamer(
				LocalDate.now(),
				"beril@beril.com",
				"12345",
        		"Beril",
        		"�zsoy",
        		"12345678911",
        		LocalDate.of(1980, 01, 01)
        		);

        Gamer gamer3 = new Gamer(
				LocalDate.now(),
				"engin@edemirog.com",
				"12345",
        		"Engin",
        		"Demiro�",
        		"12345678912",
        		LocalDate.of(1985, 01, 01)
        		);
        
		//Ger�ek MERN�S Kontroll� Kay�t
		GamerManager gamerManager = new GamerManager(serviceFactoryManager);
		gamerManager.register(gamer1);

		//Sadece TCKN Algoritma Kontroll� Kay�t
		serviceFactoryManager.release(new TCKNValidatation());
		gamerManager = new GamerManager(serviceFactoryManager);
		gamerManager.register(gamer2);

		//Sahte Kontroll� Kay�t - Response True
		serviceFactoryManager.release(new UserValidation());
		gamerManager = new GamerManager(serviceFactoryManager);
		gamerManager.register(gamer1);
		gamerManager.register(gamer2);
		gamerManager.register(gamer3);
		
		//T�m kullan�c�lar�n listelenmesi
		System.out.println(ConsoleColors.PURPLE_BRIGHT + "\n****************************************************************************************" + ConsoleColors.RESET);
		System.out.println("======================================== Users =========================================");
		System.out.println(ConsoleColors.PURPLE_BRIGHT + "****************************************************************************************\n" + ConsoleColors.RESET);
		
		System.out.format(ConsoleColors.CYAN_UNDERLINED + "%6s%13s%30s%45s", "No    ", "Kay�t Tarihi ", "�sim-Soyisim     ", "E-Posta Adresi     \n" + ConsoleColors.RESET);
		//System.out.format("%6s%13s%30s%45s", "--", "------------", "------------", "--------------\n");
		BaseUserManager baseUserManager = new BaseUserManager(new UserDbManager());
		List<User> users = baseUserManager.getAllUsers();
		for (User user : users) {
			Gamer gamer = gamerManager.getByUserId(user.getId());
		
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			String regDateString = dtf.format(user.getRegisterDate());

			System.out.format("%6s%13s%30s%45s", ConsoleColors.GREEN_BRIGHT + user.getId(), regDateString, gamer.getFirstName() + " " + gamer.getLastName(), user.getEmail() + "\n" + ConsoleColors.RESET);
			
		}
		

		//T�m oyuncular�n listelenmesi
		System.out.println(ConsoleColors.PURPLE_BRIGHT + "\n****************************************************************************************" + ConsoleColors.RESET);
		System.out.println("======================================== Gamers ========================================");
		System.out.println(ConsoleColors.PURPLE_BRIGHT + "****************************************************************************************\n" + ConsoleColors.RESET);
		
		System.out.format(ConsoleColors.CYAN_UNDERLINED + "%6s%16s%13s%30s%45s", "No    ", "TC Kimlik No    ", "Do�um Tarihi ", "�sim-Soyisim     ", "E-Posta Adresi     " + ConsoleColors.RESET + "\n");
		//System.out.format("%6s%13s%13s%30s%45s", "--", "------------", "------------", "------------", "--------------\n");
		GamerManager gamerManager2 = new GamerManager(serviceFactoryManager);
		List<Gamer> gamers = gamerManager2.getAll();
		for (Gamer gamer : gamers) {

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			String dateOfBirth = dtf.format(gamer.getDateOfBirth());
			
			System.out.format("%6s%16s%13s%30s%45s", ConsoleColors.GREEN_BRIGHT + gamer.getId(), gamer.getNationalityId(), dateOfBirth, gamer.getFirstName() + " " + gamer.getLastName(), gamer.getEmail() +"\n" + ConsoleColors.RESET );
		}
		
		//Sipari�
		OrderDetail orderDetail1 = new OrderDetail(1, 2);
		OrderDetail orderDetail2 = new OrderDetail(1, 3);
		Cart cart = new Cart(1, 1, new OrderDetail[]{orderDetail1,orderDetail2});

		System.out.println("\n========================= Sipari� ��lemi =========================");
		OrderManager orderManager = new OrderManager(serviceFactoryManager);
		orderManager.purchase(cart);
		
		//G�ncelleme
		System.out.println("\n========================= Update Gamer =========================");
		gamer1.setFirstName("G�ncelisim");
		gamerManager.update(gamer1);

		//T�m oyuncular�n tekrar listelenmesi
		System.out.println("\n========================= Gamers =========================");
		gamers = gamerManager2.getAll();
		for (Gamer gamer : gamers) {
			System.out.println(gamer.getId() + " - " + gamer.getFirstName() + " " + gamer.getLastName() + " " + gamer.getEmail());
		}

	}

}
