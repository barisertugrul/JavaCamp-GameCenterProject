package javaGameCenterProject.Data;


import java.util.ArrayList;
import java.util.List;

import javaGameCenterProject.Entities.Campaign;
import javaGameCenterProject.Entities.Game;
import javaGameCenterProject.Entities.Gamer;
import javaGameCenterProject.Entities.Order;
import javaGameCenterProject.Entities.OrderDetail;
import javaGameCenterProject.Entities.User;

public class Database {
	
	private static Database instance;
	private static List<User> users;
	private static List<Gamer> gamers;
	private static List<Game> games;
	private static List<Campaign> campaigns;
	private static List<Order> orders;
	private static List<OrderDetail> orderDetails;
	
	//Otomatik artan ID simülasyonu için
	private static int userId = 0;
	private static int gamerId = 0;
	private static int gameId = 0;
	private static int campaignId = 0;
	private static int orderId = 0;
	private static int orderDetailId = 0;


    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    
	public static List<User> getUsers() {
		if(users == null) {
			users = new ArrayList<User>();
		}
		return users;
	}

	public static List<Gamer> getGamers() {
		if(gamers == null) {
			gamers = new ArrayList<Gamer>();
		}
		return gamers;
	}


	public static List<Game> getGames() {
		if(games == null) {
			games = new ArrayList<Game>();
		}
		return games;
	}


	public static List<Campaign> getCampaigns() {
		if(campaigns == null) {
			campaigns = new ArrayList<Campaign>();
		}
		return campaigns;
	}


	public static List<Order> getOrders() {
		if(orders == null) {
			orders = new ArrayList<Order>();
		}
		return orders;
	}


	public static List<OrderDetail> getOrderDetails() {
		if(orderDetails == null) {
			orderDetails = new ArrayList<OrderDetail>();
		}
		return orderDetails;
	}


	public static int getUserId() {
		return userId;
	}


	public static int getGamerId() {
		return gamerId;
	}


	public static int getGameId() {
		return gameId;
	}


	public static int getCampaignId() {
		return campaignId;
	}


	public static int getOrderId() {
		return orderId;
	}


	public static int getOrderDetailId() {
		return orderDetailId;
	}

	public static void setUserId(int userId) {
		Database.userId = userId;
	}

	public static void setGamerId(int gamerId) {
		Database.gamerId = gamerId;
	}

	public static void setGameId(int gameId) {
		Database.gameId = gameId;
	}

	public static void setCampaignId(int campaignId) {
		Database.campaignId = campaignId;
	}

	public static void setOrderId(int orderId) {
		Database.orderId = orderId;
	}

	public static void setOrderDetailId(int orderDetailId) {
		Database.orderDetailId = orderDetailId;
	}
}
