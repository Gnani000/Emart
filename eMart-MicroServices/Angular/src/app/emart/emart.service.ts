import { Injectable } from '@angular/core';
import { Category } from './category';
import { SubCategory } from './sub-category';
import { Item } from './item';
import { Bill } from './bill';
import { Buyer } from './buyer';
import { Seller } from './seller';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmartService {
  

  categories: Category[];
  subCategories: SubCategory[];
  allItems: Item[];
  cartItems: any[];
  allBills: any;
  allBuyers: Buyer[];
  allSellers: Seller[];
  currentBuyer : any;
  
  constructor(protected http: HttpClient) { 
    this.cartItems = [];
    this.allBills = [];
   
    
  }

  setBuyer(currentBuyer: any) {
    this.currentBuyer = currentBuyer;
  }

  setAllBills(billsList: any){
    this.allBills = billsList;
  }

  getCurrentBuyer(){
    return this.currentBuyer;
  }


  getAllItems():any{
    return this.http.get('http://localhost:8083/Item-Service/emart/item/all');
  }

  getCategories():Category[]{
    return [].concat(this.categories);
  }

  getSubCategories():SubCategory[]{
    return [].concat(this.subCategories);
  }

  getAllBills():Bill[]{
    return this.allBills;
  }

  getCategory(catId: number):Category{

    return null;
  }

  getSubCategory(catId: number):SubCategory{
    
    return null;
  }

  getItem(itemId: string):any{
    
    return this.http.get('http://localhost:8083/Item-Service/emart/item/'+itemId);
  }

  addToCart(itemObj: any){

   this.cartItems.push(itemObj);
  }

  getAllCart(){
    return [].concat(this.cartItems);
  }

  setAllCart(cartItems: any){
    this.cartItems = cartItems;
  }

  deleteCartItem(itemNo: number){
    let size = this.cartItems.length;
    for(let i=0;i<size;i++){
      if(this.cartItems[i].itemId==itemNo){
        this.cartItems.splice(i,1);
        break;
      }
    }
    return [].concat(this.cartItems);
  }

  addBill( todayDate: Date, total: number){
 
    let allBillDetails: any = [];
    for(let i=0;i<this.cartItems.length; i++){
        allBillDetails.push({
          billDetailsId : 0,
          bill : null,
          item : this.cartItems[i]
        });
    }

    let bill: any = {
      billId: 0,
      billType : 'Credit',
      billDate : todayDate,
      billRemarks : 'Paid',
      billAmount : total,
      buyer: {
        buyerId : this.getCurrentBuyer().buyerId
      },
      allBillDetails : allBillDetails
    }
    this.cartItems = [];
    allBillDetails = [];
    return this.http.post("http://localhost:8083/Item-Service/emart/addBill", bill);
  }

  getBuyer(){
    return this.http.get("http://localhost:8083/Login-Service/emart/buyer" +this.currentBuyer.buyerId);
  }

  validateBuyer(user: string, password: string){
  

    let uData = user + ":" + password;
    let headers  = new HttpHeaders();
    headers  =  headers.set('Authorization', uData);
    return this.http.get('http://localhost:8083/Login-Service/emart/validate', {headers});
  }

  validateSeller(user: string, password: string){
    
  }

}
