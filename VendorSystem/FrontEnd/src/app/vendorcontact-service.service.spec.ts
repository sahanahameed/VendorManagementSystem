import { TestBed } from '@angular/core/testing';

import { VendorcontactServiceService } from './vendorcontact-service.service';

describe('VendorcontactServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VendorcontactServiceService = TestBed.get(VendorcontactServiceService);
    expect(service).toBeTruthy();
  });
});
