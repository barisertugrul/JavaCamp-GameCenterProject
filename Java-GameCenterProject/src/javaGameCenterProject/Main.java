package javaGameCenterProject;

import java.time.LocalDate;
import java.util.List;

import javaGameCenterProject.Abstract.BaseUserManager;
import javaGameCenterProject.Adapters.MernisServiceAdapter;
import javaGameCenterProject.Adapters.TCKNValidatation;
import javaGameCenterProject.Adapters.UserValidation;
import javaGameCenterProject.Concrete.CampaignManager;
import javaGameCenterProject.Concrete.GameManager;
import javaGameCenterProject.Concrete.GamerManager;
import javaGameCenterProject.Data.Concrete.CampaignDbManager;
import javaGameCenterProject.Data.Concrete.GameDbManager;
import javaGameCenterProject.Data.Concrete.GamerDbManager;
import javaGameCenterProject.Data.Concrete.UserDbManager;
import javaGameCenterProject.Entities.Campaign;
import javaGameCenterProject.Entities.Game;
import javaGameCenterProject.Entities.Gamer;
import javaGameCenterProject.Entities.User;

public class Main {

	public static void main(String[] args) {
		
		//Add game
		Game game = new Game(1, "U�an Kodcular Java Edition", "v1.0", LocalDate.now(),25.0,35);
		GameManager gameManager = new GameManager(new GameDbManager());
		gameManager.add(game);
		
		//Add campaign
		Campaign campaign = new Campaign("Csharp��dan Javac�ya Zeytin Dal�", LocalDate.now(), LocalDate.of(2021, 8, 30), "Java Geli�tiricilerine Csharp�� masas�ndan indirim taba��", 0.3);
		CampaignManager campaignManager = new CampaignManager(new CampaignDbManager());
		campaignManager.add(campaign);
		
		//Add gamer
		Gamer gamer1 = new Gamer(
				LocalDate.now(),
				"barisertugrul@barisertugrul.com",
				"12345",
        		"Bar��",
        		"Ertu�rul",
        		"012345678910",
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
		GamerManager gamerManager = new GamerManager(new UserDbManager(),new GamerDbManager(), new MernisServiceAdapter());
		gamerManager.register(gamer1);

		//Sadece TCKN Algoritma Kontroll� Kay�t
		gamerManager = new GamerManager(new UserDbManager(),new GamerDbManager(), new TCKNValidatation());
		gamerManager.register(gamer2);

		//Sahte Kontroll� Kay�t - Response True
		gamerManager = new GamerManager(new UserDbManager(),new GamerDbManager(), new UserValidation());
		gamerManager.register(gamer1);
		gamerManager.register(gamer2);
		gamerManager.register(gamer3);
		
		//T�m kullan�c�lar�n listelenmesi
		System.out.println("\n========================= Users =========================");
		BaseUserManager baseUserManager = new BaseUserManager(new UserDbManager());
		List<User> users = baseUserManager.getAllUsers();
		for (User user : users) {
			System.out.println(user.getId() + " - " + user.getRegisterDate());
		}
		

		//T�m oyuncular�n listelenmesi
		System.out.println("\n========================= Gamers =========================");
		GamerManager gamerManager2 = new GamerManager(new UserDbManager(), new GamerDbManager(), new MernisServiceAdapter());
		List<Gamer> gamers = gamerManager2.getAll();
		for (Gamer gamer : gamers) {
			System.out.println(gamer.getId() + " - " + gamer.getFirstName() + gamer.getLastName());
		}
		
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
