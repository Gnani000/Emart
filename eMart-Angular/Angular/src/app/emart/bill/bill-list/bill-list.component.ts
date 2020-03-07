import { Component, OnInit } from '@angular/core';
import { EmartService } from '../../emart.service';

@Component({
  selector: 'app-bill-list',
  templateUrl: './bill-list.component.html',
  styleUrls: ['./bill-list.component.css']
})
export class BillListComponent implements OnInit {

  allBills: any;
  currentBuyer: any;
  showBill: boolean;
  constructor(protected emartService: EmartService) { }

  ngOnInit(): void {
    this.currentBuyer = this.emartService.getCurrentBuyer();
    this.allBills = this.emartService.getAllBills();
    if (this.allBills.length == 0) {
      this.showBill = false;
    }
    else {
      this.showBill = true;
    }

  }

}
