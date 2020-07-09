import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModule } from './login/login.module';
import { HttpClientModule } from '@angular/common/http';
import { LayoutModule } from './layout/layout.module';
import { AdminModule } from './admin/admin.module';
import { DescriptionsComponent } from './admin/descriptions/descriptions.component';
import { FoldersComponent } from './admin/folders/folders.component';
import { DocumentsComponent } from './admin/documents/documents.component';
import { InterestsComponent } from './admin/interests/interests.component';
import { InterestgroupsComponent } from './admin/interestgroups/interestgroups.component';
import { LibrariesComponent } from './admin/libraries/libraries.component';
import { SearchconnectionsComponent } from './admin/searchconnections/searchconnections.component';
import { SubscribesComponent } from './admin/subscribes/subscribes.component';
import { TagsComponent } from './admin/tags/tags.component';

/** 
 * Modulo principale dell'applicazione. Qui vengono importati i moduli secondari. L'UNICA component
 * da dichiare qui è l'AppComponent, tutte le altre devono essere dichiarate nel loro modulo e questo importato
 * qui.
 * 
 * @author Vittorio Valent
*/
@NgModule({
  declarations: [
    AppComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LoginModule,
    HttpClientModule,
    LayoutModule,
    AdminModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
