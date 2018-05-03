package com.nkl.admin.manager;

import java.util.Date;
import java.util.List;

import com.nkl.admin.dao.CustomDao;
import com.nkl.admin.dao.KindDao;
import com.nkl.admin.dao.GoodsDao;
import com.nkl.admin.dao.LogisticsDao;
import com.nkl.admin.dao.OrdersDao;
import com.nkl.admin.dao.PurchaseDao;
import com.nkl.admin.dao.SupplierDao;
import com.nkl.admin.dao.UsersDao;
import com.nkl.admin.domain.Custom;
import com.nkl.admin.domain.Kind;
import com.nkl.admin.domain.Goods;
import com.nkl.admin.domain.Logistics;
import com.nkl.admin.domain.Orders;
import com.nkl.admin.domain.Purchase;
import com.nkl.admin.domain.Supplier;
import com.nkl.admin.domain.Users;
import com.nkl.common.util.DateUtil;
import com.nkl.common.util.Md5;
import com.nkl.common.util.Param;
import com.nkl.common.util.StringUtil;
import com.nkl.common.util.UID;

public class AdminManager {
	
	//所有待注入Dao类
	CustomDao customDao;
	SupplierDao supplierDao;
	KindDao kindDao;
	GoodsDao goodsDao;
	OrdersDao ordersDao;
	PurchaseDao purchaseDao;
	UsersDao usersDao;
	LogisticsDao logisticsDao;
	
	/**
	 * @Title: listUserss
	 * @Description: 查询用户集合
	 * @param user
	 * @return List<User>
	 */
	public List<Users> listUserss(Users user, int[] sum) {
		if (sum != null) {
			sum[0] = usersDao.listUserssCount(user);
		}
		List<Users> users = usersDao.listUserss(user);
		return users;
	}

	/**
	 * @Title: queryUser
	 * @Description: 用户单个查询
	 * @param user
	 * @return User
	 */
	public Users queryUser(Users user) {
		Users _user = usersDao.getUsers(user);
		return _user;
	}

	/**
	 * @Title: addUser
	 * @Description: 添加用户
	 * @param user
	 * @return void
	 */
	public void addUsers(Users user) {
		//密码MD5加密
		if (!StringUtil.isEmptyString(user.getUser_pass())) {
			user.setUser_pass(Md5.makeMd5(user.getUser_pass()));
		}
		//添加用户
		user.setUser_id(UID.getInstanse().getUID());
		usersDao.addUsers(user);
	}

	/**
	 * @Title: updateUsers
	 * @Description: 更新用户信息
	 * @param user
	 * @return void
	 */
	public void updateUser(Users user) {
		//密码MD5加密
		if (!StringUtil.isEmptyString(user.getUser_pass())) {
			user.setUser_pass(Md5.makeMd5(user.getUser_pass()));
		}
		usersDao.updateUsers(user);
	}

	/**
	 * @Title: delUsers
	 * @Description: 删除用户信息
	 * @param user
	 * @return void
	 */
	public void delUserss(Users user) {
		usersDao.delUserss(user.getIds().split(","));
	}
	
	/**
	 * @Title: listCustoms
	 * @Description: 查询客户信息集合
	 * @param custom
	 * @return List<Custom>
	 */
	public List<Custom> listCustoms(Custom custom, int[] sum) {
		if (sum != null) {
			sum[0] = customDao.listCustomsCount(custom);
		}
		List<Custom> customs = customDao.listCustoms(custom);
		return customs;
	}

	/**
	 * @Title: queryCustom
	 * @Description: 客户信息单个查询
	 * @param custom
	 * @return Custom
	 */
	public Custom queryCustom(Custom custom) {
		Custom _custom = customDao.getCustom(custom);
		return _custom;
	}

	/**
	 * @Title: addCustom
	 * @Description: 添加客户信息
	 * @param custom
	 * @return void
	 */
	public void addCustom(Custom custom) {
		//添加客户信息
		custom.setCustom_id(UID.getInstanse().getUID());
		customDao.addCustom(custom);
	}

	/**
	 * @Title: updateCustom
	 * @Description: 更新客户信息信息
	 * @param custom
	 * @return void
	 */
	public void updateCustom(Custom custom) {
		customDao.updateCustom(custom);
	}

	/**
	 * @Title: delCustoms
	 * @Description: 删除客户信息信息
	 * @param custom
	 * @return void
	 */
	public void delCustoms(Custom custom) {
		customDao.delCustoms(custom.getIds().split(","));
	}
	
	/**
	 * @Title: listSuppliers
	 * @Description: 查询供应商信息集合
	 * @param supplier
	 * @return List<Supplier>
	 */
	public List<Supplier> listSuppliers(Supplier supplier, int[] sum) {
		if (sum != null) {
			sum[0] = supplierDao.listSuppliersCount(supplier);
		}
		List<Supplier> suppliers = supplierDao.listSuppliers(supplier);
		return suppliers;
	}

	/**
	 * @Title: querySupplier
	 * @Description: 供应商信息单个查询
	 * @param supplier
	 * @return Supplier
	 */
	public Supplier querySupplier(Supplier supplier) {
		Supplier _supplier = supplierDao.getSupplier(supplier);
		return _supplier;
	}

	/**
	 * @Title: addSupplier
	 * @Description: 添加供应商信息
	 * @param supplier
	 * @return void
	 */
	public void addSupplier(Supplier supplier) {
		//添加供应商信息
		supplier.setSupplier_id(UID.getInstanse().getUID());
		supplierDao.addSupplier(supplier);
	}

	/**
	 * @Title: updateSupplier
	 * @Description: 更新供应商信息信息
	 * @param supplier
	 * @return void
	 */
	public void updateSupplier(Supplier supplier) {
		supplierDao.updateSupplier(supplier);
	}

	/**
	 * @Title: delSuppliers
	 * @Description: 删除供应商信息信息
	 * @param supplier
	 * @return void
	 */
	public void delSuppliers(Supplier supplier) {
		supplierDao.delSuppliers(supplier.getIds().split(","));
	}
	
	/**
	 * @Title: listKinds
	 * @Description: 查询商品类型集合
	 * @param kind
	 * @return List<Kind>
	 */
	public List<Kind> listKinds(Kind kind, int[] sum) {
		if (sum != null) {
			sum[0] = kindDao.listKindsCount(kind);
		}
		List<Kind> kinds = kindDao.listKinds(kind);
		return kinds;
	}

	/**
	 * @Title: queryKind
	 * @Description: 商品类型单个查询
	 * @param kind
	 * @return Kind
	 */
	public Kind queryKind(Kind kind) {
		Kind _kind = kindDao.getKind(kind);
		return _kind;
	}

	/**
	 * @Title: addKind
	 * @Description: 添加商品类型
	 * @param kind
	 * @return void
	 */
	public void addKind(Kind kind) {
		//添加商品类型
		kind.setKind_id(UID.getInstanse().getUID());
		kindDao.addKind(kind);
	}

	/**
	 * @Title: updateKind
	 * @Description: 更新商品类型信息
	 * @param kind
	 * @return void
	 */
	public void updateKind(Kind kind) {
		kindDao.updateKind(kind);
	}

	/**
	 * @Title: delKinds
	 * @Description: 删除商品类型信息
	 * @param kind
	 * @return void
	 */
	public void delKinds(Kind kind) {
		kindDao.delKinds(kind.getIds().split(","));
	}
	
	/**
	 * @Title: listGoodss
	 * @Description: 查询货物集合
	 * @param goods
	 * @return List<Goods>
	 */
	public List<Goods> listGoodss(Goods goods, int[] sum) {
		if (sum != null) {
			sum[0] = goodsDao.listGoodssCount(goods);
		}
		List<Goods> goodss = goodsDao.listGoodss(goods);
		return goodss;
	}

	/**
	 * @Title: queryGoods
	 * @Description: 货物单个查询
	 * @param goods
	 * @return Goods
	 */
	public Goods queryGoods(Goods goods) {
		Goods _goods = goodsDao.getGoods(goods);
		return _goods;
	}

	/**
	 * @Title: addGoods
	 * @Description: 添加货物
	 * @param goods
	 * @return void
	 */
	public void addGoods(Goods goods) {
		//添加货物
		goods.setGoods_id(UID.getInstanse().getUID());
		goods.setGoods_count(0);
		goods.setMax_count(0);
		goods.setAlarm_count(0);
		goods.setGoods_flag(0);
		goodsDao.addGoods(goods);
	}

	/**
	 * @Title: updateGoods
	 * @Description: 更新货物信息
	 * @param goods
	 * @return void
	 */
	public void updateGoods(Goods goods) {
		goodsDao.updateGoods(goods);
	}
	
	/**
	 * @Title: updateGoodsCount
	 * @Description: 更新货物库存信息
	 * @param goods
	 * @return void
	 */
	public void updateGoodsCount(Goods goods) {
		//更新库存状态
		if (goods.getGoods_count()!=null) {
			if (goods.getGoods_count() >= goods.getMax_count()) {
				goods.setGoods_flag(3);
			}else if (goods.getGoods_count() <= goods.getAlarm_count()) {
				goods.setGoods_flag(2);
			}else {
				goods.setGoods_flag(1);
			}
		}
		goodsDao.updateGoodsCount(goods);
	}

	/**
	 * @Title: delGoodss
	 * @Description: 删除货物信息
	 * @param goods
	 * @return void
	 */
	public void delGoodss(Goods goods) {
		goodsDao.delGoodss(goods.getIds().split(","));
	}
	
	/**
	 * @Title: listPurchases
	 * @Description: 查询采购申请
	 * @param purchase
	 * @return List<Purchase>
	 */
	public List<Purchase> listPurchases(Purchase purchase, int[] sum) {
		if (sum != null) {
			sum[0] = purchaseDao.listPurchasesCount(purchase);
		}
		List<Purchase> purchases = purchaseDao.listPurchases(purchase);
		return purchases;
	}
	
	/**
	 * @Title: listPurchasesSum
	 * @Description: 查询采购统计
	 * @param purchase
	 * @return List<Purchase>
	 */
	public List<Purchase> listPurchasesSum(Purchase purchase, int[] sum) {
		if (sum != null) {
			sum[0] = purchaseDao.listPurchasesSumCount(purchase);
		}
		List<Purchase> purchases = purchaseDao.listPurchasesSum(purchase);
		return purchases;
	}
	
	/**
	 * @Title: queryPurchase
	 * @Description: 采购订单查询
	 * @param orders
	 * @return Orders
	 */
	public Purchase queryPurchase(Purchase purchase) {
		Purchase _purchase = purchaseDao.getPurchase(purchase);
		return _purchase;
	}

	/**
	 * @Title: addPurchase
	 * @Description: 添加采购申请
	 * @param purchase
	 * @return void
	 */
	public void addPurchase(Purchase purchase) {
		//添加入库
		Users admin = (Users)Param.getSession("admin");
		purchase.setApply_flag(1);//初始
		purchase.setApply_id(admin.getUser_id());
		purchase.setApply_name(admin.getReal_name());
		purchase.setApply_date(new Date());
		purchase.setPurchase_money(Math.round(purchase.getGoods_price()*purchase.getGoods_count()*100)/100.0);
		purchase.setPurchase_id(UID.getInstanse().getUID());
		purchaseDao.addPurchase(purchase);
	}
	
	/**
	 * @Title: updatePurchase
	 * @Description: 更新采购申请
	 * @param purchase
	 * @return void
	 */
	public void updatePurchase(Purchase purchase) {
		purchase.setPurchase_money(Math.round(purchase.getGoods_price()*purchase.getGoods_count()*100)/100.0);
		purchaseDao.updatePurchase(purchase);
	}

	/**
	 * @Title: delPurchases
	 * @Description: 删除采购申请
	 * @param purchase
	 * @return void
	 */
	public void delPurchases(Purchase purchase) {
		purchaseDao.delPurchases2(purchase.getIds().split(","));
	}
	
	/**
	 * @Title: addPurchaseOrder
	 * @Description: 添加采购订单
	 * @param purchase
	 * @return void
	 */
	public void addPurchaseOrder(Purchase purchase) {
		purchase = purchaseDao.getPurchase(purchase);
		//更新采购申请
		Users admin = (Users)Param.getSession("admin");
		purchase.setApply_flag(2);//生成订单
		//订单编号
		purchase.setPurchase_no(DateUtil.dateToDateString(new Date(),"yyyyMMddHHmmss")+admin.getUser_id());
		//订单日期
		purchase.setOrders_date(new Date());
		//订单状态1-待确认
		purchase.setPurchase_flag(1);
		purchase.setBuy_id(admin.getUser_id());
		purchase.setBuy_name(admin.getReal_name());
		purchaseDao.updatePurchase(purchase);
		
	}
	
	/**
	 * @Title: updatePurchaseOrder
	 * @Description: 更新采购订单
	 * @param purchase
	 * @return void
	 */
	public void updatePurchaseOrder(Purchase purchase) {
		//更新采购申请
		Purchase _purchase = purchaseDao.getPurchase(purchase);
		if (purchase.getPurchase_flag()==3) {
			purchase.setCheck_flag(1);//未检验
		}else if (purchase.getPurchase_flag()==4) {
			purchase.setCheck_flag(2);//合格
		}else if (purchase.getPurchase_flag()==6) {
			purchase.setCheck_flag(3);//不合格
		}else if (purchase.getPurchase_flag()==5) {
			//更新库存数量
			Goods goods = new Goods();
			goods.setGoods_id(_purchase.getGoods_id());
			goods = goodsDao.getGoods(goods);
			goods.setGoods_count(goods.getGoods_count() + _purchase.getGoods_count());
			if (goods.getGoods_count() >= goods.getMax_count()) {
				goods.setGoods_flag(3);
			}else if (goods.getGoods_count() <= goods.getAlarm_count()) {
				goods.setGoods_flag(2);
			}else {
				goods.setGoods_flag(1);
			}
			goodsDao.updateGoodsCount(goods);
			
		}
		purchaseDao.updatePurchase(purchase);
		
	}
	
	/**
	 * @Title: delPurchasesOrders
	 * @Description: 删除采购订单
	 * @param purchase
	 * @return void
	 */
	public void delPurchasesOrders(Purchase purchase) {
		purchaseDao.delPurchases(purchase.getIds().split(","));
	}
	
	/**
	 * @Title: listOrderss
	 * @Description: 查询销售订单
	 * @param orders
	 * @return List<Orders>
	 */
	public List<Orders> listOrderss(Orders orders, int[] sum) {
		if (sum != null) {
			sum[0] = ordersDao.listOrderssCount(orders);
		}
		List<Orders> orderss = ordersDao.listOrderss(orders);
		return orderss;
	}
	
	/**
	 * @Title: listOrderssSum
	 * @Description: 查询销售统计
	 * @param orders
	 * @return List<Orders>
	 */
	public List<Orders> listOrderssSum(Orders orders, int[] sum) {
		if (sum != null) {
			sum[0] = ordersDao.listOrderssSumCount(orders);
		}
		List<Orders> orderss = ordersDao.listOrderssSum(orders);
		return orderss;
	}

	/**
	 * @Title: queryOrders
	 * @Description: 销售订单查询
	 * @param orders
	 * @return Orders
	 */
	public Orders queryOrders(Orders orders) {
		Orders _orders = ordersDao.getOrders(orders);
		return _orders;
	}

	/**
	 * @Title: addOrders
	 * @Description: 添加销售订单
	 * @param orders
	 * @return void
	 */
	public void addOrders(Orders orders) {
		Users admin = (Users)Param.getSession("admin");
		orders.setApply_id(admin.getUser_id());
		orders.setApply_name(admin.getReal_name());
		orders.setApply_date(new Date());
		orders.setOrders_money(Math.round(orders.getGoods_price()*orders.getGoods_count()*100)/100.0);
		//订单编号
		orders.setOrders_no(DateUtil.dateToDateString(new Date(),"yyyyMMddHHmmss")+orders.getApply_id());
		//订单状态1-待出库
		orders.setOrders_flag(1);
		//添加订单
		orders.setOrders_id(UID.getInstanse().getUID());
		ordersDao.addOrders(orders);
	}
	
	/**
	 * @Title: updateOrders
	 * @Description: 更新销售订单
	 * @param orders
	 * @return void
	 */
	public void updateOrders(Orders orders) {
		orders.setOrders_money(Math.round(orders.getGoods_price()*orders.getGoods_count()*100)/100.0);
		ordersDao.updateOrders(orders);
	}

	/**
	 * @Title: confirmOrderss
	 * @Description: 确认销售订单
	 * @param orders
	 * @return void
	 */
	public void confirmOrderss(Orders orders) {
		orders.setOrders_flag(2);//待收货
		ordersDao.updateOrders(orders);
		
		orders = ordersDao.getOrders(orders);
		//更新库存数量
		Goods goods = new Goods();
		goods.setGoods_id(orders.getGoods_id());
		goods = goodsDao.getGoods(goods);
		goods.setGoods_count(goods.getGoods_count() - orders.getGoods_count());
		if (goods.getGoods_count() >= goods.getMax_count()) {
			goods.setGoods_flag(3);
		}else if (goods.getGoods_count() <= goods.getAlarm_count()) {
			goods.setGoods_flag(2);
		}else {
			goods.setGoods_flag(1);
		}
		goodsDao.updateGoodsCount(goods);
	}
	
	/**
	 * @Title: updateOrdersFlag
	 * @Description: 更新销售订单状态
	 * @param orders
	 * @return void
	 */
	public void updateOrdersFlag(Orders orders) {
		ordersDao.updateOrders(orders);
		
		orders = ordersDao.getOrders(orders);
		if (orders.getOrders_flag()==7) {
			//更新库存数量
			Goods goods = new Goods();
			goods.setGoods_id(orders.getGoods_id());
			goods = goodsDao.getGoods(goods);
			goods.setGoods_count(goods.getGoods_count() + orders.getGoods_count());
			if (goods.getGoods_count() >= goods.getMax_count()) {
				goods.setGoods_flag(3);
			}else if (goods.getGoods_count() <= goods.getAlarm_count()) {
				goods.setGoods_flag(2);
			}else {
				goods.setGoods_flag(1);
			}
			goodsDao.updateGoodsCount(goods);
		}
		
	}

	/**
	 * @Title: delOrderss
	 * @Description: 删除销售订单
	 * @param orders
	 * @return void
	 */
	public void delOrderss(Orders orders) {
		ordersDao.delOrderss(orders.getIds().split(","));
	}
	
	/**
	 * @Title: listLogisticss
	 * @Description: 商品订单物流信息查询
	 * @param logistics
	 * @return List<Logistics>
	 */
	public List<Logistics>  listLogisticss(Logistics logistics,int[] sum){
		if (sum!=null) {
			sum[0] = logisticsDao.listLogisticssCount(logistics);
		}
		List<Logistics> logisticss = logisticsDao.listLogisticss(logistics);
		
		return logisticss;
	}
	
	/**
	 * @Title: addLogistics
	 * @Description: 新增物流信息
	 * @param logistics
	 * @return void
	 */
	public void addLogistics(Logistics logistics) {
		logistics.setLogistics_id(UID.getInstanse().getUID());
		logisticsDao.addLogistics(logistics);
	}

	public CustomDao getCustomDao() {
		return customDao;
	}

	public KindDao getKindDao() {
		return kindDao;
	}

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	public OrdersDao getOrdersDao() {
		return ordersDao;
	}

	public PurchaseDao getPurchaseDao() {
		return purchaseDao;
	}

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public LogisticsDao getLogisticsDao() {
		return logisticsDao;
	}

	public void setCustomDao(CustomDao customDao) {
		this.customDao = customDao;
	}

	public void setKindDao(KindDao kindDao) {
		this.kindDao = kindDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	public void setPurchaseDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public void setLogisticsDao(LogisticsDao logisticsDao) {
		this.logisticsDao = logisticsDao;
	}

	public SupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}
	

	 
	
}
