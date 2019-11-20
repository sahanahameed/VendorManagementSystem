import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Vendor } from './vendor';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VendorcontactServiceService {
  
  constructor(private _httpService: HttpClient) { }

  getVendors(): Observable<Vendor[]>{
    return this._httpService.get<Vendor[]>(environment.APIUrl +'/vendors');
  }

  searchVendors(searchString: string): Observable<Vendor[]>{
    return this._httpService.get<Vendor[]>(environment.APIUrl +'/vendor/'+ searchString);
  }

  addVendors(vendor: Vendor)
  {
    console.log("Vendor : " +vendor);
    let body = JSON.stringify(vendor);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

    console.log("VendorId : " +vendor.vendorId);
    if(vendor.vendorId)
    {
      return this._httpService.put(environment.APIUrl +'/saveVendor', body, options);
    }
    else
    {
      return this._httpService.post(environment.APIUrl +'/saveVendor', body, options);
    } 
  }
  getVendorById(vendorId: string): Observable<Vendor>{
    return this._httpService.get<Vendor>(environment.APIUrl +'/getVendor/'+ vendorId);
  }

  disableVendor(vendorId:number): Observable<Vendor>{
    let body = JSON.stringify(vendorId);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }
    return this._httpService.put<Vendor>(environment.APIUrl +'/disableVendor/'+ vendorId,body,options);
  }


}


