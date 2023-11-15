import { TestBed } from '@angular/core/testing';

import { AnalysisManagerService } from './analysis-manager.service';

describe('AnalysisManagerService', () => {
  let service: AnalysisManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AnalysisManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
