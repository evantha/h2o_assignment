import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpParams } from "@angular/common/http";
import { Feedback } from '../models/feedback';
import { Observable } from 'rxjs';

const URI = 'http://www.localhost:8080/api/v1';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpClient: HttpClient) { }

  saveFeedback(feedback: Feedback): Observable<Feedback> {
    return this.httpClient.post<Feedback>(`${URI}/feedback`, feedback);
  }

  getAllFeedback(): Observable<Feedback[]> {
    return this.httpClient.get<Feedback[]>(`${URI}/feedback`);
  }
}
