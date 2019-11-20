import { Component, OnInit } from '@angular/core';
import { Vendor } from '../vendor';
import { VendorcontactServiceService } from '../vendorcontact-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-viewvendor',
  templateUrl: './viewvendor.component.html',
  styleUrls: ['./viewvendor.component.scss']
})
export class ViewvendorComponent implements OnInit {

  vendorlist: Vendor[];
  vendor = new Vendor();
  searchString: string;

  constructor(private _vendorContactService: VendorcontactServiceService,private router: Router) { }

  ngOnInit() {

    this.getAllVendors();

  }

  viewall(): void
  {
    this.getAllVendors();
  }

  addvendor():void
  {
    this.router.navigate(['addvendor']);
  }

  editvendor(vendorId: number): void {
    this.router.navigate(['addvendor/'+vendorId]);
  }
  getAllVendors(): void {
    this._vendorContactService.getVendors()
      .subscribe((userData) => {
        this.vendorlist = userData,
          console.log(userData);
      }, (error) => {
        console.log(error);
      });
  }

  searchVendors(searchString: string)  
   {    
    console.log(searchString);   
     this._vendorContactService.searchVendors(searchString)  
    .subscribe((response) => {        
      console.log(response);       
       this.vendorlist = response        
      console.log(this.vendorlist);        
      this.searchString = undefined     
     }, (error) => { 
       console.log(error);  });   
     }    
    
    disableVendor(vendorId:number): void {     
       console.log(vendorId);     
       this._vendorContactService.disableVendor(vendorId)    
          .subscribe((disableData) => {          
         
                this.vendor = disableData        
          console.log(this.vendor);         
         this.getAllVendors();        
      }, (error) => {        
          console.log(error);       
       });   
     } 
    back(){
      this.router.navigate(['viewvendor'])
    }
    logout(){
      this.router.navigate(['login'])
    }
   }