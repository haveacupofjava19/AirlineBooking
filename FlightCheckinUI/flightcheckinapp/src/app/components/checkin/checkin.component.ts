import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { DataService } from "src/app/services/data.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-checkin",
  templateUrl: "./checkin.component.html",
  styleUrls: ["./checkin.component.css"]
})
export class CheckinComponent implements OnInit {
  data: any;
  checkInResponse: any;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private service: DataService
  ) {}

  ngOnInit() {
    var id = Number.parseInt(this.route.snapshot.paramMap.get("id"));
    this.service.getReservation(id).subscribe(res => {
      this.data = res;
    });
  }

  checkin(noOfBags) {
    var checkinRequest: any = new Object();
    checkinRequest.id = this.data.id;
    checkinRequest.checkedIn = true;
    checkinRequest.numberOfBags = noOfBags;

    this.service.checkin(checkinRequest).subscribe(res => {
      this.checkInResponse = res;
    });
    this.router.navigate(["/confirm"]);
  }
}
