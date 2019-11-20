import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { Router, ActivatedRoute } from '@angular/router';
import { VendorcontactServiceService } from '../vendorcontact-service.service';

@Component({
  selector: 'app-addvendor',
  templateUrl: './addvendor.component.html',
  styleUrls: ['./addvendor.component.scss']
})
export class AddvendorComponent implements OnInit {

  vendor = new Vendor();
  searchString: string;

  constructor(private router: Router,private _vendorContactService: VendorcontactServiceService,private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => this.getVendorById(params['vendorId']));
  }

  private reset() {
    this.vendor.vendorId = null;
    this.vendor.vendorName = '';
    this.vendor.vendorAddress = '';
    this.vendor.vendorLocation = '';
    this.vendor.vService = '';
    this.vendor.vPincode = null;
    this.vendor.contactName = '';
    this.vendor.pDepartment = '';
    this.vendor.pEmail = '';
    this.vendor.pPhone = null;
  }

  back(){
    this.router.navigate(['viewvendor'])
  }

  saveVendors(): void {
    console.log(this.vendor);
    this._vendorContactService.addVendors(this.vendor)
      .subscribe((response) => {
        console.log(response);
        this.reset;
        this.router.navigate(['viewvendor']);
      }, (error) => {
        console.log(error);
      });
  }

  getVendorById(vendId: string) {
    console.log(vendId);
    this._vendorContactService.getVendorById(vendId)
      .subscribe((vendorData) => {
        this.vendor = vendorData;
        console.log(vendorData);
      }, (error) => {
        console.log(error);
      });
  }

  updateVendor(): void {
    console.log(this.vendor);
    this._vendorContactService.addVendors(this.vendor)
      .subscribe((response) => {
        console.log(response);
        this.router.navigate(['view'])
      }, (error) => {
        console.log(error);
      });
  }

}

