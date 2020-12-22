import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { Feedback } from '../../models/feedback';
import { Product } from '../../models/product';
import { ApiService } from '../../services/api.service';
import { ToastrService } from 'ngx-toastr';

const USER_ID = 'user1';
const PRODUCTS_ARRAY = [
  new Product(1, 'H2O'),
  new Product(2, 'Sparkling Water'),
  new Product(3, 'H2O Driverless AI'),
  new Product(4, 'H2O Wave'),
  new Product(5, 'Enterprise Puddle'),
];
const CURRENT_RATING = 5;

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css'],
})
export class RatingComponent implements OnInit, OnChanges {
  @Input()
  readonly: boolean;
  @Input()
  feedback = new Feedback(PRODUCTS_ARRAY[0].id, '', USER_ID, CURRENT_RATING);

  // currentRating = 8;
  products = PRODUCTS_ARRAY;

  // model = new Feedback(this.products[0].id, '', USER_ID, this.currentRating);

  constructor(private apiService: ApiService, private toastr: ToastrService) {}

  ngOnInit(): void {}

  ngOnChanges() {
    console.log(this.feedback);
  }

  onSubmit() {
    console.log(this.feedback);
    this.apiService.saveFeedback(this.feedback).subscribe(
      (res) => {
        this.toastr.success('Successfully saved');
        this.feedback = new Feedback(
          PRODUCTS_ARRAY[0].id,
          '',
          USER_ID,
          CURRENT_RATING
        );
      },
      (err) => this.toastr.error('Error occurred')
    );
  }
}
