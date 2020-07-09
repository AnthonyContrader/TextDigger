import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isDescriptionCollapsed = false;
  isDocumentCollapsed = false;
  isFolderCollapsed = false;
  isInterestGroupCollapsed = false;
  isInterestCollapsed = false;
  isLibraryCollapsed = false;
  isSearchConnectionCollapsed = false;
  isSubscribeCollapsed = false;
  isTagsCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }

  descriptionscollapse() {
    if (this.isDescriptionCollapsed === false) {
      this.isDescriptionCollapsed = true;
    } else { this.isDescriptionCollapsed = false; }
  }

  documentscollapse() {
    if (this.isDocumentCollapsed === false) {
      this.isDocumentCollapsed = true;
    } else { this.isDocumentCollapsed = false; }
  }

  folderscollapse() {
    if (this.isFolderCollapsed === false) {
      this.isFolderCollapsed = true;
    } else { this.isFolderCollapsed = false; }
  }

  interestgroupscollapse() {
    if (this.isInterestGroupCollapsed === false) {
      this.isInterestGroupCollapsed = true;
    } else { this.isInterestGroupCollapsed = false; } 
  }

  interestscollapse() {
    if (this.isInterestCollapsed === false) {
      this.isInterestCollapsed = true;
    } else { this.isInterestCollapsed = false; } 
  }

  librariescollapse() {
    if (this.isLibraryCollapsed === false) {
      this.isLibraryCollapsed = true;
    } else { this.isLibraryCollapsed = false; }
  }

  searchconnectionscollapse() {
    if (this.isSearchConnectionCollapsed === false) {
      this.isSearchConnectionCollapsed = true;
    } else { this.isSearchConnectionCollapsed = false; }
  }

  subscribescollapse() {
    if (this.isSubscribeCollapsed === false) {
      this.isSubscribeCollapsed = true;
    } else { this.isSubscribeCollapsed = false; }
  }

  tagscollapse() {
    if (this.isTagsCollapsed === false) {
      this.isTagsCollapsed = true;
    } else { this.isTagsCollapsed = false; }
  }
}
