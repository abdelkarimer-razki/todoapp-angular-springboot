import { TestBed } from '@angular/core/testing';

import { Todolistdata } from './todolistdata';

describe('Todolistdata', () => {
  let service: Todolistdata;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Todolistdata);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
