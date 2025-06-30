import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './error/error.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ProductsComponent } from './products/products.component';
import { ContactComponent } from './contact/contact.component';
import { DetailsComponent } from './details/details.component';
import { CanActivateGuard } from './guards/canActivate.guard';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { CanDeactivateGuard } from './guards/canDeactivate.guard';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'about', component: AboutComponent },
  { path: 'products', component: ProductsComponent },
  {
    path: 'product/:id',
    component: DetailsComponent,
    canActivate: [CanActivateGuard],
  },
  { path: 'contact', component: ContactComponent },
  { path: 'login', component: LoginComponent },
  {path:'signup', component:SignupComponent, canDeactivate:[CanDeactivateGuard]},
  { path: '**', component: ErrorComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
