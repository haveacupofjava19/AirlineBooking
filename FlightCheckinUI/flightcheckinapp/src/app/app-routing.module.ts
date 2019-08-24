import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { StartcheckinComponent } from "./components/startcheckin/startcheckin.component";
import { CheckinComponent } from "./components/checkin/checkin.component";
import { ConfirmcheckinComponent } from "./components/confirmcheckin/confirmcheckin.component";
import { FormsModule } from "@angular/forms";

const routes: Routes = [
  {
    path: "",
    redirectTo: "",
    pathMatch: "full"
  },
  {
    path: "startCheckIn",
    component: StartcheckinComponent
  },
  { path: "checkin/:id", component: CheckinComponent },
  {
    path: "confirm",
    component: ConfirmcheckinComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes), FormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule {}
