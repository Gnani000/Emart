import { Component, OnInit } from '@angular/core';
import { EmartService } from '../../emart.service';
import { BillDetails } from '../../bill-details';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bill-view',
  templateUrl: './bill-view.component.html',
  styleUrls: ['./bill-view.component.css']
})
export class BillViewComponent implements OnInit {
  cartItems: any;
  amount: number = 0;
  allBills: any;
  allBillDetails: BillDetails[];
  currentBuyer: any;
  todayDate: Date = new Date();

  constructor(protected emartService: EmartService,
    protected router: Router) { }

  ngOnInit(): void {
    this.currentBuyer = this.emartService.getCurrentBuyer();
    this.cartItems = this.emartService.getAllCart();
    let size = this.cartItems.length;
    console.log(size);
    for (let i = 0; i < size; i++) {
      this.amount = this.amount + this.cartItems[i].itemPrice;
    }
  }

  
  addBill() {
    this.emartService.addBill(this.todayDate, this.amount).subscribe(
      (res) => {
        let newBill: any = res;
        this.allBills = this.emartService.getAllBills();
        this.allBills.push(newBill);
        this.emartService.setAllBills(this.allBills);
      }
    );
    this.router.navigate(['item-list']);
  }

}
