package com.nkl.admin.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nkl.admin.domain.Custom;
import com.nkl.admin.domain.Kind;
import com.nkl.admin.domain.Goods;
import com.nkl.admin.domain.Logistics;
import com.nkl.admin.domain.Orders;
import com.nkl.admin.domain.Purchase;
import com.nkl.admin.domain.Supplier;
import com.nkl.admin.domain.Users;
import com.nkl.admin.manager.AdminManager;
import com.nkl.common.action.BaseAction;
import com.nkl.common.util.BeanLocator;
import com.nkl.common.util.Param;

public class AdminAction  extends BaseAction {

	private static final long serialVersionUID = 1L;
	AdminManager adminManager = (AdminManager)BeanLocator.getInstance().getBean("adminManager");
	
	//抓取页面参数
	Users paramsUsers;
	Kind paramsKind;
	Custom paramsCustom;
	Supplier paramsSupplier;
	Goods paramsGoods;
	Orders paramsOrders;
	Purchase paramsPurchase;
	Logistics paramsLogistics;
	
	String tip;
	
	/**
	 * @Title: saveAdmin
	 * @Description: 保存修改个人信息
	 * @return String
	 */
	public String saveAdmin(){
		try {
			//验证用户会话是否失效
			if (!validateAdmin()) {
				return "loginTip";
			}
			 //保存修改个人信息
			adminManager.updateUser(paramsUsers);
			//更新session
			Users  admin = new Users();
			admin.setUser_id(paramsUsers.getUser_id());
			admin = adminManager.queryUser(admin);
			Param.setSession("admin", admin);
			
			setSuccessTip("编辑成功", "modifyInfo.jsp");
			
		} catch (Exception e) {
			setErrorTip("编辑异常", "modifyInfo.jsp");
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: saveAdminPass
	 * @Description: 保存修改个人密码
	 * @return String
	 */
	public String saveAdminPass(){
		try {
			//验证用户会话是否失效
			if (!validateAdmin()) {
				return "loginTip";
			}
			 //保存修改个人密码
			adminManager.updateUser(paramsUsers);
			//更新session
			Users  admin = (Users)Param.getSession("admin");
			if (admin!=null) {
				admin.setUser_pass(paramsUsers.getUser_pass());
				Param.setSession("admin", admin);
			}
			
			setSuccessTip("修改成功", "modifyPwd.jsp");
		} catch (Exception e) {
			setErrorTip("修改异常", "modifyPwd.jsp");
		}
		
		return "infoTip";
	}
	
	
	/**
	 * @Title: listUserss
	 * @Description: 查询用户
	 * @return String
	 */
	public String listUserss(){
		try {
			if (paramsUsers==null) {
				paramsUsers = new Users();
				paramsUsers.setUser_type(1);
			}
			//设置分页信息
			setPagination(paramsUsers);
			//总的条数
			int[] sum={0};
			//查询用户列表
			List<Users> userss = adminManager.listUserss(paramsUsers,sum); 
			Param.setAttribute("userss", userss);
			setTotalCount(sum[0]);
			
			Param.setAttribute("user_type", paramsUsers.getUser_type());
			Param.setAttribute("user_typeDesc", paramsUsers.getUser_typeDesc());
			
		} catch (Exception e) {
			setErrorTip("查询用户异常", "main.jsp");
			return "infoTip";
		}
		
		return "usersShow";
	}
	
	/**
	 * @Title: addUsersShow
	 * @Description: 显示添加用户页面
	 * @return String
	 */
	public String addUsersShow(){
		Param.setAttribute("user_type", paramsUsers.getUser_type());
		Param.setAttribute("user_typeDesc", paramsUsers.getUser_typeDesc());
		
		return "usersEdit";
	}
	
	/**
	 * @Title: addUsers
	 * @Description: 添加用户
	 * @return String
	 */
	public String addUsers(){
		try {
			//检查用户是否存在
			Users  users = new Users();
			users.setUser_name(paramsUsers.getUser_name());
			users = adminManager.queryUser(users);
			if (users!=null) {
				tip="失败，该用户名已经存在！";
				Param.setAttribute("users", paramsUsers);
				return "usersEdit";
			}
			
			 //添加用户
			paramsUsers.setReg_date(new Date());
			adminManager.addUsers(paramsUsers);
			
			setSuccessTip("添加成功", "Admin_listUserss.action?paramsUsers.user_type="+paramsUsers.getUser_type());
		} catch (Exception e) {
			setErrorTip("添加用户异常", "Admin_listUserss.action?paramsUsers.user_type="+paramsUsers.getUser_type());
		}
		
		return "infoTip";
	}
	
	 
	/**
	 * @Title: editUser
	 * @Description: 编辑用户
	 * @return String
	 */
	public String editUsers(){
		try {
			 //得到用户
			Users  user = adminManager.queryUser(paramsUsers);
			Param.setAttribute("user", user);
			
			Param.setAttribute("user_type", paramsUsers.getUser_type());
			Param.setAttribute("user_typeDesc", paramsUsers.getUser_typeDesc());
			
		} catch (Exception e) {
			e.printStackTrace();
			setErrorTip("查询用户异常", "Admin_listUserss.action?paramsUsers.user_type="+paramsUsers.getUser_type());
			return "infoTip";
		}
		
		return "usersEdit";
	}
	
	/**
	 * @Title: saveUser
	 * @Description: 保存编辑用户
	 * @return String
	 */
	public String saveUsers(){
		try {
			 //保存编辑用户
			adminManager.updateUser(paramsUsers);
			
			setSuccessTip("编辑成功", "Admin_listUserss.action?paramsUsers.user_type="+paramsUsers.getUser_type());
		} catch (Exception e) {
			tip="编辑失败";
			Param.setAttribute("user", paramsUsers);
			
			Param.setAttribute("user_type", paramsUsers.getUser_type());
			Param.setAttribute("user_typeDesc", paramsUsers.getUser_typeDesc());
			
			return "userEdit";
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: delUserss
	 * @Description: 删除用户
	 * @return String
	 */
	public String delUserss(){
		try {
			 //删除用户
			adminManager.delUserss(paramsUsers);
			
			setSuccessTip("删除用户成功", "Admin_listUserss.action?paramsUsers.user_type="+paramsUsers.getUser_type());
		} catch (Exception e) {
			setErrorTip("删除用户异常", "Admin_listUserss.action?paramsUsers.user_type="+paramsUsers.getUser_type());
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: listCustoms
	 * @Description: 查询客户信息
	 * @return String
	 */
	public String listCustoms(){
		try {
			if (paramsCustom==null) {
				paramsCustom = new Custom();
			}
			//设置分页信息
			setPagination(paramsCustom);
			//总的条数
			int[] sum={0};
			//查询客户信息列表
			List<Custom> customs = adminManager.listCustoms(paramsCustom,sum); 
			Param.setAttribute("customs", customs);
			setTotalCount(sum[0]);
			
		} catch (Exception e) {
			setErrorTip("查询客户信息异常", "main.jsp");
			return "infoTip";
		}
		
		return "customShow";
	}
	
	/**
	 * @Title: addCustomShow
	 * @Description: 显示添加客户信息页面
	 * @return String
	 */
	public String addCustomShow(){
		return "customEdit";
	}
	
	/**
	 * @Title: addCustom
	 * @Description: 添加客户信息
	 * @return String
	 */
	public String addCustom(){
		try {
			 //添加客户信息
			adminManager.addCustom(paramsCustom);
			
			setSuccessTip("添加成功", "Admin_listCustoms.action");
		} catch (Exception e) {
			setErrorTip("添加客户信息异常", "Admin_listCustoms.action");
		}
		
		return "infoTip";
	}
	
	 
	/**
	 * @Title: editCustom
	 * @Description: 编辑客户信息
	 * @return String
	 */
	public String editCustom(){
		try {
			 //得到客户信息
			Custom custom = adminManager.queryCustom(paramsCustom);
			Param.setAttribute("custom", custom);
			
		} catch (Exception e) {
			setErrorTip("查询客户信息异常", "Admin_listCustoms.action");
			return "infoTip";
		}
		
		return "customEdit";
	}
	
	/**
	 * @Title: saveCustom
	 * @Description: 保存编辑客户信息
	 * @return String
	 */
	public String saveCustom(){
		try {
			 //保存编辑客户信息
			adminManager.updateCustom(paramsCustom);
			
			setSuccessTip("编辑成功", "Admin_listCustoms.action");
		} catch (Exception e) {
			tip="编辑失败";
			Param.setAttribute("custom", paramsCustom);
			return "customEdit";
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: delCustoms
	 * @Description: 删除客户信息
	 * @return String
	 */
	public String delCustoms(){
		try {
			 //删除客户信息
			adminManager.delCustoms(paramsCustom);
			
			setSuccessTip("删除客户信息成功", "Admin_listCustoms.action");
		} catch (Exception e) {
			setErrorTip("删除客户信息异常", "Admin_listCustoms.action");
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: listSuppliers
	 * @Description: 查询供应商信息
	 * @return String
	 */
	public String listSuppliers(){
		try {
			if (paramsSupplier==null) {
				paramsSupplier = new Supplier();
			}
			//设置分页信息
			setPagination(paramsSupplier);
			//总的条数
			int[] sum={0};
			//查询供应商信息列表
			List<Supplier> suppliers = adminManager.listSuppliers(paramsSupplier,sum); 
			Param.setAttribute("suppliers", suppliers);
			setTotalCount(sum[0]);
			
		} catch (Exception e) {
			setErrorTip("查询供应商信息异常", "main.jsp");
			return "infoTip";
		}
		
		return "supplierShow";
	}
	
	/**
	 * @Title: addSupplierShow
	 * @Description: 显示添加供应商信息页面
	 * @return String
	 */
	public String addSupplierShow(){
		return "supplierEdit";
	}
	
	/**
	 * @Title: addSupplier
	 * @Description: 添加供应商信息
	 * @return String
	 */
	public String addSupplier(){
		try {
			 //添加供应商信息
			adminManager.addSupplier(paramsSupplier);
			
			setSuccessTip("添加成功", "Admin_listSuppliers.action");
		} catch (Exception e) {
			setErrorTip("添加供应商信息异常", "Admin_listSuppliers.action");
		}
		
		return "infoTip";
	}
	
	 
	/**
	 * @Title: editSupplier
	 * @Description: 编辑供应商信息
	 * @return String
	 */
	public String editSupplier(){
		try {
			 //得到供应商信息
			Supplier supplier = adminManager.querySupplier(paramsSupplier);
			Param.setAttribute("supplier", supplier);
			
		} catch (Exception e) {
			setErrorTip("查询供应商信息异常", "Admin_listSuppliers.action");
			return "infoTip";
		}
		
		return "supplierEdit";
	}
	
	/**
	 * @Title: saveSupplier
	 * @Description: 保存编辑供应商信息
	 * @return String
	 */
	public String saveSupplier(){
		try {
			 //保存编辑供应商信息
			adminManager.updateSupplier(paramsSupplier);
			
			setSuccessTip("编辑成功", "Admin_listSuppliers.action");
		} catch (Exception e) {
			tip="编辑失败";
			Param.setAttribute("supplier", paramsSupplier);
			return "supplierEdit";
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: delSuppliers
	 * @Description: 删除供应商信息
	 * @return String
	 */
	public String delSuppliers(){
		try {
			 //删除供应商信息
			adminManager.delSuppliers(paramsSupplier);
			
			setSuccessTip("删除供应商信息成功", "Admin_listSuppliers.action");
		} catch (Exception e) {
			setErrorTip("删除供应商信息异常", "Admin_listSuppliers.action");
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: listKinds
	 * @Description: 查询商品类型
	 * @return String
	 */
	public String listKinds(){
		try {
			if (paramsKind==null) {
				paramsKind = new Kind();
			}
			//设置分页信息
			setPagination(paramsKind);
			//总的条数
			int[] sum={0};
			//查询商品类型列表
			List<Kind> kinds = adminManager.listKinds(paramsKind,sum); 
			
			Param.setAttribute("kinds", kinds);
			setTotalCount(sum[0]);
			
		} catch (Exception e) {
			setErrorTip("查询商品类型异常", "main.jsp");
			return "infoTip";
		}
		
		return "kindShow";
	}
	
	/**
	 * @Title: addKindShow
	 * @Description: 显示添加商品类型页面
	 * @return String
	 */
	public String addKindShow(){
		return "kindEdit";
	}
	
	/**
	 * @Title: addKind
	 * @Description: 添加商品类型
	 * @return String
	 */
	public String addKind(){
		try {
			//检查登录名是否存在
			Kind kind = new Kind();
			kind.setKind_name(paramsKind.getKind_name());
			kind = adminManager.queryKind(kind);
			if (kind!=null) {
				tip="失败，该商品类型已经存在！";
				Param.setAttribute("kind", paramsKind);
				return "kindEdit";
			}
			 //添加商品类型
			adminManager.addKind(paramsKind);
			
			setSuccessTip("添加成功", "Admin_listKinds.action");
		} catch (Exception e) {
			setErrorTip("添加商品类型异常", "Admin_listKinds.action");
		}
		
		return "infoTip";
	}
	
	 
	/**
	 * @Title: editKind
	 * @Description: 编辑商品类型
	 * @return String
	 */
	public String editKind(){
		try {
			 //得到商品类型
			Kind kind = adminManager.queryKind(paramsKind);
			Param.setAttribute("kind", kind);
			
		} catch (Exception e) {
			setErrorTip("查询商品类型异常", "Admin_listKinds.action");
			return "infoTip";
		}
		
		return "kindEdit";
	}
	
	/**
	 * @Title: saveKind
	 * @Description: 保存编辑商品类型
	 * @return String
	 */
	public String saveKind(){
		try {
			//检查登录名是否存在
			Kind kind = new Kind();
			kind.setKind_name(paramsKind.getKind_name());
			kind = adminManager.queryKind(kind);
			if (kind!=null && !kind.getKind_id().equals(paramsKind.getKind_id())) {
				tip="失败，该商品类型已经存在！";
				Param.setAttribute("kind", paramsKind);
				return "kindEdit";
			}
			
			 //保存编辑商品类型
			adminManager.updateKind(paramsKind);
			
			setSuccessTip("编辑成功", "Admin_listKinds.action");
		} catch (Exception e) {
			tip="编辑失败";
			Param.setAttribute("kind", paramsKind);
			return "kindEdit";
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: delKinds
	 * @Description: 删除商品类型
	 * @return String
	 */
	public String delKinds(){
		try {
			 //删除商品类型
			adminManager.delKinds(paramsKind);
			
			setSuccessTip("删除商品类型成功", "Admin_listKinds.action");
		} catch (Exception e) {
			setErrorTip("删除商品类型异常", "Admin_listKinds.action");
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: listGoodss
	 * @Description: 查询商品
	 * @return String
	 */
	public String listGoodss(){
		try {
			if (paramsGoods==null) {
				paramsGoods = new Goods();
			}
			//设置分页信息
			setPagination(paramsGoods);
			//总的条数
			int[] sum={0};
			//查询商品列表
			List<Goods> goodss = adminManager.listGoodss(paramsGoods,sum); 
			Param.setAttribute("goodss", goodss);
			setTotalCount(sum[0]);
			
			//商品类型字典
			Kind kind = new Kind();
			kind.setStart(-1);
			List<Kind> kinds = adminManager.listKinds(kind, null);
			if (kinds==null) {
				kinds = new ArrayList<Kind>();
			}
			Param.setAttribute("kinds", kinds);
			
			
		} catch (Exception e) {
			setErrorTip("查询商品异常", "main.jsp");
			return "infoTip";
		}
		
		return "goodsShow";
	}
	
	/**
	 * @Title: queryGoods
	 * @Description: 查看商品
	 * @return String
	 */
	public String queryGoods(){
		try {
			 //得到商品
			Goods goods = adminManager.queryGoods(paramsGoods);
			Param.setAttribute("goods", goods);
			
		} catch (Exception e) {
			setErrorTip("查询商品异常", "Admin_listGoodss.action");
			return "infoTip";
		}
		
		return "goodsDetail";
	}
	
	/**
	 * @Title: addGoodsShow
	 * @Description: 显示添加商品页面
	 * @return String
	 */
	public String addGoodsShow(){
		//商品类型字典
		Kind kind = new Kind();
		kind.setStart(-1);
		List<Kind> kinds = adminManager.listKinds(kind, null);
		if (kinds==null) {
			kinds = new ArrayList<Kind>();
		}
		Param.setAttribute("kinds", kinds);
		
		return "goodsEdit";
	}
	
	/**
	 * @Title: addGoods
	 * @Description: 添加商品
	 * @return String
	 */
	public String addGoods(){
		try {
			//检查登录名是否存在
			Goods goods = new Goods();
			goods.setGoods_no(paramsGoods.getGoods_no());
			goods = adminManager.queryGoods(goods);
			if (goods!=null) {
				tip="失败，该商品编号已经存在！";
				Param.setAttribute("goods", paramsGoods);
				
				//商品类型字典
				Kind kind = new Kind();
				kind.setStart(-1);
				List<Kind> kinds = adminManager.listKinds(kind, null);
				if (kinds==null) {
					kinds = new ArrayList<Kind>();
				}
				Param.setAttribute("kinds", kinds);
				return "goodsEdit";
			}
			 //添加商品
			adminManager.addGoods(paramsGoods);
			
			setSuccessTip("添加成功", "Admin_listGoodss.action");
		} catch (Exception e) {
			setErrorTip("添加商品异常", "Admin_listGoodss.action");
		}
		
		return "infoTip";
	}
	
	 
	/**
	 * @Title: editGoods
	 * @Description: 编辑商品
	 * @return String
	 */
	public String editGoods(){
		try {
			 //得到商品
			Goods goods = adminManager.queryGoods(paramsGoods);
			Param.setAttribute("goods", goods);
			
			//商品类型字典
			Kind kind = new Kind();
			kind.setStart(-1);
			List<Kind> kinds = adminManager.listKinds(kind, null);
			if (kinds==null) {
				kinds = new ArrayList<Kind>();
			}
			Param.setAttribute("kinds", kinds);
			
		} catch (Exception e) {
			setErrorTip("查询商品异常", "Admin_listGoodss.action");
			return "infoTip";
		}
		
		return "goodsEdit";
	}
	
	/**
	 * @Title: saveGoods
	 * @Description: 保存编辑商品
	 * @return String
	 */
	public String saveGoods(){
		try {
			 //保存编辑商品
			adminManager.updateGoods(paramsGoods);
			
			setSuccessTip("编辑成功", "Admin_listGoodss.action");
		} catch (Exception e) {
			e.printStackTrace();
			tip="编辑失败";
			Param.setAttribute("goods", paramsGoods);
			
			//商品类型字典
			Kind kind = new Kind();
			kind.setStart(-1);
			List<Kind> kinds = adminManager.listKinds(kind, null);
			if (kinds==null) {
				kinds = new ArrayList<Kind>();
			}
			Param.setAttribute("kinds", kinds);
			return "goodsEdit";
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: delGoodss
	 * @Description: 删除商品
	 * @return String
	 */
	public String delGoodss(){
		try {
			 //删除商品
			adminManager.delGoodss(paramsGoods);
			
			setSuccessTip("删除商品成功", "Admin_listGoodss.action");
		} catch (Exception e) {
			setErrorTip("删除商品异常", "Admin_listGoodss.action");
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: listGoodsStocks
	 * @Description: 查询商品库存
	 * @return String
	 */
	public String listGoodsStocks(){
		try {
			if (paramsGoods==null) {
				paramsGoods = new Goods();
			}
			//设置分页信息
			setPagination(paramsGoods);
			//总的条数
			int[] sum={0};
			//查询商品列表
			List<Goods> goodss = adminManager.listGoodss(paramsGoods,sum); 
			Param.setAttribute("goodss", goodss);
			setTotalCount(sum[0]);
			
			//商品类型字典
			Kind kind = new Kind();
			kind.setStart(-1);
			List<Kind> kinds = adminManager.listKinds(kind, null);
			if (kinds==null) {
				kinds = new ArrayList<Kind>();
			}
			Param.setAttribute("kinds", kinds);
			
			
		} catch (Exception e) {
			setErrorTip("查询商品库存异常", "main.jsp");
			return "infoTip";
		}
		
		return "goodsStockShow";
	}
	
	/**
	 * @Title: editGoodsStock
	 * @Description: 编辑商品库存
	 * @return String
	 */
	public String editGoodsStock(){
		try {
			 //得到商品
			Goods goods = adminManager.queryGoods(paramsGoods);
			Param.setAttribute("goods", goods);
			
			//商品类型字典
			Kind kind = new Kind();
			kind.setStart(-1);
			List<Kind> kinds = adminManager.listKinds(kind, null);
			if (kinds==null) {
				kinds = new ArrayList<Kind>();
			}
			Param.setAttribute("kinds", kinds);
			
		} catch (Exception e) {
			setErrorTip("查询商品库存异常", "Admin_listGoodsStocks.action");
			return "infoTip";
		}
		
		return "goodsStockEdit";
	}
	
	/**
	 * @Title: saveGoodsStock
	 * @Description: 保存编辑商品库存
	 * @return String
	 */
	public String saveGoodsStock(){
		try {
			 //保存编辑商品
			adminManager.updateGoodsCount(paramsGoods);
			
			setSuccessTip("编辑成功", "Admin_listGoodsStocks.action");
		} catch (Exception e) {
			tip="编辑失败";
			Param.setAttribute("goods", paramsGoods);
			
			//商品类型字典
			Kind kind = new Kind();
			kind.setStart(-1);
			List<Kind> kinds = adminManager.listKinds(kind, null);
			if (kinds==null) {
				kinds = new ArrayList<Kind>();
			}
			Param.setAttribute("kinds", kinds);
			return "goodsStockEdit";
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: listPurchases
	 * @Description: 查询采购申请
	 * @return String
	 */
	public String listPurchases(){
		try {
			if (paramsPurchase==null) {
				paramsPurchase = new Purchase();
			}
			//设置分页信息
			setPagination(paramsPurchase);
			//总的条数
			int[] sum={0};
			//查询采购申请列表
			paramsPurchase.setApply_flags("1,2");
			List<Purchase> purchases = adminManager.listPurchases(paramsPurchase,sum); 
			Param.setAttribute("purchases", purchases);
			setTotalCount(sum[0]);
			
		} catch (Exception e) {
			setErrorTip("查询采购申请异常", "main.jsp");
			return "infoTip";
		}
		
		return "purchaseShow";
	}
	
	/**
	 * @Title: listPurchasesSum
	 * @Description: 查询采购统计
	 * @return String
	 */
	public String listPurchasesSum(){
		try {
			if (paramsPurchase==null) {
				paramsPurchase = new Purchase();
			}
			//设置分页信息
			setPagination(paramsPurchase);
			//总的条数
			int[] sum={0};
			//查询采购申请列表
			paramsPurchase.setPurchase_flag(5);
			List<Purchase> purchases = adminManager.listPurchasesSum(paramsPurchase,sum); 
			Param.setAttribute("purchases", purchases);
			setTotalCount(sum[0]);
			
			double total_money = 0.0;
			if (purchases!=null && purchases.size()>0) {
				for (Purchase _purchase : purchases) {
					total_money+=_purchase.getPurchase_money();
				}
			}
			Param.setAttribute("total_money", total_money);
			
			
		} catch (Exception e) {
			setErrorTip("查询采购统计异常", "main.jsp");
			return "infoTip";
		}
		
		return "purchaseSumShow";
	}
	
	/**
	 * @Title: addPurchaseShow
	 * @Description: 显示添加采购申请页面
	 * @return String
	 */
	public String addPurchaseShow(){
		//查询商品信息
		Goods goods = new Goods();
		goods.setStart(-1);
		List<Goods> goodss = adminManager.listGoodss(goods, null);
		if (goodss==null) {
			goodss = new ArrayList<Goods>();
		}
		Param.setAttribute("goodss", goodss);
		
		//查询供应商信息
		Supplier supplier = new Supplier();
		supplier.setStart(-1);
		List<Supplier> suppliers = adminManager.listSuppliers(supplier, null);
		if (suppliers!=null) {
			Param.setAttribute("suppliers", suppliers);
		}else {
			Param.setAttribute("suppliers", new ArrayList<Supplier>());
		}
		
		return "purchaseEdit";
	}
	
	/**
	 * @Title: addPurchase
	 * @Description: 添加采购申请
	 * @return String
	 */
	public String addPurchase(){
		try {
			 //添加采购申请
			adminManager.addPurchase(paramsPurchase);
			
			setSuccessTip("添加成功", "Admin_listPurchases.action");
		} catch (Exception e) {
			setErrorTip("添加采购申请异常", "Admin_listPurchases.action");
		}
		
		return "infoTip";
	}
	 
	/**
	 * @Title: delPurchases
	 * @Description: 删除采购申请
	 * @return String
	 */
	public String delPurchases(){
		try {
			 //删除采购申请
			adminManager.delPurchases(paramsPurchase);
			
			setSuccessTip("删除采购申请成功", "Admin_listPurchases.action");
		} catch (Exception e) {
			setErrorTip("删除采购申请异常", "Admin_listPurchases.action");
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: addPurchaseOrders
	 * @Description: 生成采购订单
	 * @return String
	 */
	public String addPurchaseOrders(){
		try {
			 //删除采购申请
			adminManager.addPurchaseOrder(paramsPurchase);
			
			setSuccessTip("生成采购订单成功", "Admin_listPurchases.action");
		} catch (Exception e) {
			setErrorTip("生成采购订单异常", "Admin_listPurchases.action");
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: listPurchaseOrderss
	 * @Description: 查询采购订单
	 * @return String
	 */
	public String listPurchaseOrderss(){
		try {
			if (paramsPurchase==null) {
				paramsPurchase = new Purchase();
			}
			//设置分页信息
			setPagination(paramsPurchase);
			//总的条数
			int[] sum={0};
			//用户身份认证
//			Users  admin = (Users)Param.getSession("admin");
//			if (admin.getUser_type()==1) {
//				paramsOrders.setOrders_flags("1,6,7");
//			}else if (admin.getUser_type()==4) {
//				paramsOrders.setOrders_flags("4,5");
//			}
			//查询采购申请列表
			paramsPurchase.setApply_flags("2,3");
			paramsPurchase.setPurchase_flags("1,2,3,4,5,6,7");
			List<Purchase> purchases = adminManager.listPurchases(paramsPurchase,sum); 
			Param.setAttribute("purchases", purchases);
			setTotalCount(sum[0]);
			
		} catch (Exception e) {
			setErrorTip("查询采购申请异常", "main.jsp");
			return "infoTip";
		}
		
		return "purchaseOrdersShow";
	}
	
	/**
	 * @Title: queryPurchaseOrders
	 * @Description: 查询采购订单
	 * @return String
	 */
	public String queryPurchaseOrders(){
		try {
			 //得到商品类型
			Purchase purchase = adminManager.queryPurchase(paramsPurchase);
			Param.setAttribute("purchase", purchase);
			
		} catch (Exception e) {
			setErrorTip("查询采购订单异常", "Admin_listPurchaseOrderss.action");
			return "infoTip";
		}
		
		return "purchaseOrdersDetail";
	}
	
	/**
	 * @Title: updatePurchaseOrders
	 * @Description: 更新采购订单
	 * @return String
	 */
	public String updatePurchaseOrders(){
		try {
			adminManager.updatePurchaseOrder(paramsPurchase);
			setSuccessTip("操作成功", "Admin_listPurchaseOrderss.action");
		} catch (Exception e) {
			setErrorTip("操作失败", "Admin_listPurchaseOrderss.action");
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: delPurchaseOrderss
	 * @Description: 删除采购订单
	 * @return String
	 */
	public String delPurchaseOrderss(){
		try {
			 //删除采购申请
			adminManager.delPurchasesOrders(paramsPurchase);
			
			setSuccessTip("删除采购订单成功", "Admin_listPurchaseOrderss.action");
		} catch (Exception e) {
			setErrorTip("删除采购订单异常", "Admin_listPurchaseOrderss.action");
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: listOrderss
	 * @Description: 查询销售订单
	 * @return String
	 */
	public String listOrderss(){
		try {
			if (paramsOrders==null) {
				paramsOrders = new Orders();
			}
			//设置分页信息
			setPagination(paramsOrders);
			//总的条数
			int[] sum={0};
			//用户身份认证
//			Users  admin = (Users)Param.getSession("admin");
//			if (admin.getUser_type()==1) {
//				paramsOrders.setOrders_flags("1,6,7");
//			}else if (admin.getUser_type()==4) {
//				paramsOrders.setOrders_flags("4,5");
//			}
			//查询销售订单列表
			List<Orders> orderss = adminManager.listOrderss(paramsOrders,sum); 
			
			Param.setAttribute("orderss", orderss);
			setTotalCount(sum[0]);
			
		} catch (Exception e) {
			setErrorTip("查询销售订单异常", "main.jsp");
			return "infoTip";
		}
		
		return "ordersShow";
	}
	
	/**
	 * @Title: listOrderssSum
	 * @Description: 查询销售统计
	 * @return String
	 */
	public String listOrderssSum(){
		try {
			if (paramsOrders==null) {
				paramsOrders = new Orders();
			}
			//设置分页信息
			setPagination(paramsOrders);
			//总的条数
			int[] sum={0};
			//查询销售订单列表
			paramsOrders.setOrders_flag(5);
			List<Orders> orderss = adminManager.listOrderssSum(paramsOrders,sum); 
			Param.setAttribute("orderss", orderss);
			setTotalCount(sum[0]);
			
			double total_money = 0.0;
			if (orderss!=null && orderss.size()>0) {
				for (Orders _orders : orderss) {
					total_money+=_orders.getOrders_money();
				}
			}
			Param.setAttribute("total_money", total_money);
			
		} catch (Exception e) {
			setErrorTip("查询销售统计异常", "main.jsp");
			return "infoTip";
		}
		
		return "ordersSumShow";
	}
	
	/**
	 * @Title: addOrdersShow
	 * @Description: 显示添加销售订单页面
	 * @return String
	 */
	public String addOrdersShow(){
		//查询商品信息
		Goods goods = new Goods();
		goods.setStart(-1);
		List<Goods> goodss = adminManager.listGoodss(goods, null);
		if (goodss!=null) {
			Param.setAttribute("goodss", goodss);
		}else {
			Param.setAttribute("goodss", new ArrayList<Goods>());
		}
		
		//查询客户信息
		Custom custom = new Custom();
		custom.setStart(-1);
		List<Custom> customs = adminManager.listCustoms(custom, null);
		if (customs!=null) {
			Param.setAttribute("customs", customs);
		}else {
			Param.setAttribute("customs", new ArrayList<Custom>());
		}
		
		return "ordersEdit";
	}
	
	/**
	 * @Title: addOrders
	 * @Description: 添加销售订单
	 * @return String
	 */
	public String addOrders(){
		try {
			 //添加销售订单
			adminManager.addOrders(paramsOrders);
			
			setSuccessTip("添加成功", "Admin_listOrderss.action");
		} catch (Exception e) {
			setErrorTip("添加销售订单异常", "Admin_listOrderss.action");
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: editOrders
	 * @Description: 显示编辑销售订单页面
	 * @return String
	 */
	public String editOrders(){
		//查询商品信息
		Goods goods = new Goods();
		goods.setStart(-1);
		List<Goods> goodss = adminManager.listGoodss(goods, null);
		if (goodss!=null) {
			Param.setAttribute("goodss", goodss);
		}else {
			Param.setAttribute("goodss", new ArrayList<Goods>());
		}
		
		Param.setAttribute("orders", adminManager.queryOrders(paramsOrders));
		
		return "ordersEdit";
	}
	
	/**
	 * @Title: saveOrders
	 * @Description: 更新销售订单
	 * @return String
	 */
	public String saveOrders(){
		try {
			 //添加销售订单
			adminManager.updateOrders(paramsOrders);
			
			setSuccessTip("编辑成功", "Admin_listOrderss.action");
		} catch (Exception e) {
			setErrorTip("编辑异常", "Admin_listOrderss.action");
		}
		
		return "infoTip";
	}
	
	
	/**
	 * @Title: confirmOrderss
	 * @Description: 审核销售订单
	 * @return String
	 */
	public String confirmOrderss(){
		try {
			 //审核销售订单
			adminManager.confirmOrderss(paramsOrders);
			
			setSuccessTip("确认出库成功", "Admin_listOrderss.action");
		} catch (Exception e) {
			setErrorTip("确认出库异常", "Admin_listOrderss.action");
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: updateOrdersFlag
	 * @Description: 更新销售订单
	 * @return String
	 */
	public String updateOrdersFlag(){
		try {
			 //更新销售订单
			adminManager.updateOrdersFlag(paramsOrders);
			
			setSuccessTip("操作成功", "Admin_listOrderss.action");
		} catch (Exception e) {
			setErrorTip("操作异常", "Admin_listOrderss.action");
		}
		
		return "infoTip";
	}
	 
	/**
	 * @Title: delOrderss
	 * @Description: 删除销售订单
	 * @return String
	 */
	public String delOrderss(){
		try {
			 //删除销售订单
			adminManager.delOrderss(paramsOrders);
			
			setSuccessTip("销售订单删除成功", "Admin_listOrderss.action");
		} catch (Exception e) {
			setErrorTip("销售订单删除异常", "Admin_listOrderss.action");
		}
		
		return "infoTip";
	}
	
	
	/**
	 * @Title: listLogisticss
	 * @Description: 查询商品订单物流信息
	 * @return String
	 */
	public String listLogisticss(){
		try {
			if (paramsLogistics==null) {
				paramsLogistics = new Logistics();
			}
			//设置分页信息不分页
			paramsLogistics.setStart(-1);
			//查询商品订单物流信息
			List<Logistics> logisticss = adminManager.listLogisticss(paramsLogistics,null); 
			Param.setAttribute("logisticss", logisticss);
			Param.setAttribute("orders_no", paramsLogistics.getOrders_no());
			
//			Purchase orders = new Purchase();
//			orders.setPurchase_no(paramsLogistics.getOrders_no());
//			orders = adminManager.queryPurchase(orders);
//			Param.setAttribute("orders", orders);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			setErrorTip("查询商品订单物流信息异常", "main.jsp");
			return "infoTip";
		}
		
		return "logisticsShow";
	}
	
	/**
	 * @Title: addLogisticsShow
	 * @Description: 显示添加物流信息页面
	 * @return String
	 */
	public String addLogisticsShow(){
		Param.setAttribute("orders_no", paramsLogistics.getOrders_no());
		return "logisticsEdit";
	}
	
	/**
	 * @Title: addLogistics
	 * @Description: 添加物流信息
	 * @return String
	 */
	public String addLogistics(){
		try {
			 //添加物流信息
			adminManager.addLogistics(paramsLogistics);

			setSuccessTip("添加物流信息成功", "Admin_listLogisticss.action?paramsLogistics.orders_no="+paramsLogistics.getOrders_no());
		} catch (Exception e) {
			setErrorTip("添加物流信息异常", "Admin_listLogisticss.action?paramsLogistics.orders_no="+paramsLogistics.getOrders_no());
		}
		return "infoTip";
	}
	
	
	/**
	 * @Title: validateAdmin
	 * @Description: admin登录验证
	 * @return boolean
	 */
	private boolean validateAdmin(){
		Users  admin = (Users)Param.getSession("admin");
		if (admin!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	private void setErrorTip(String tip,String url){
		Param.setAttribute("tipType", "error");
		Param.setAttribute("tip", tip);
		Param.setAttribute("url1", url);
		Param.setAttribute("value1", "确 定");
	}
	
	private void setSuccessTip(String tip,String url){
		Param.setAttribute("tipType", "success");
		Param.setAttribute("tip", tip);
		Param.setAttribute("url1", url);
		Param.setAttribute("value1", "确 定");
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Kind getParamsKind() {
		return paramsKind;
	}

	public void setParamsKind(Kind paramsKind) {
		this.paramsKind = paramsKind;
	}

	public Goods getParamsGoods() {
		return paramsGoods;
	}

	public void setParamsGoods(Goods paramsGoods) {
		this.paramsGoods = paramsGoods;
	}

	public Orders getParamsOrders() {
		return paramsOrders;
	}

	public void setParamsOrders(Orders paramsOrders) {
		this.paramsOrders = paramsOrders;
	}

	public Purchase getParamsPurchase() {
		return paramsPurchase;
	}

	public void setParamsPurchase(Purchase paramsPurchase) {
		this.paramsPurchase = paramsPurchase;
	}

	public Logistics getParamsLogistics() {
		return paramsLogistics;
	}

	public void setParamsLogistics(Logistics paramsLogistics) {
		this.paramsLogistics = paramsLogistics;
	}

	public Users getParamsUsers() {
		return paramsUsers;
	}

	public Custom getParamsCustom() {
		return paramsCustom;
	}

	public void setParamsUsers(Users paramsUsers) {
		this.paramsUsers = paramsUsers;
	}

	public void setParamsCustom(Custom paramsCustom) {
		this.paramsCustom = paramsCustom;
	}

	public Supplier getParamsSupplier() {
		return paramsSupplier;
	}

	public void setParamsSupplier(Supplier paramsSupplier) {
		this.paramsSupplier = paramsSupplier;
	}
	 
	
}
