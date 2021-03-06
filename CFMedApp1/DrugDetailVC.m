//
//  DrugAdministrationVC.m
//  CFMedApp1
//
//  Created by Matt Watson on 09/02/2015.
//  Copyright (c) 2015 Matthew Watson. All rights reserved.
//

#import "DrugDetailVC.h"
#import "PathogensForDrugVC.h"

@interface DrugDetailVC ()

@end

@implementation DrugDetailVC
@synthesize drug;
@synthesize adminBarDisplay;


- (void)viewDidLoad {
    
    //Loads the data into the user interface
    [super viewDidLoad];
    [self fillFields];
    [self adultSetting];
    [self buttonLogic];
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

//Changes the layout for adult setting.
- (void)adultSetting{
    
    NSMutableString *title= [[NSMutableString alloc]init];
    [title appendString:drug.getGenericName];
    [title appendString:@" -Adult"];
    self.typeLabel.text = drug.getTypeOfDrug;
    self.navigationItem.title = title;
    [_paedSwitch setBackgroundColor: [UIColor whiteColor]];
    [_paedSwitch setTitleColor:[UIColor redColor] forState:UIControlStateNormal];
    [_adultSwitch setBackgroundColor :[UIColor redColor]];
    [_adultSwitch setTitleColor:[UIColor whiteColor] forState:UIControlStateSelected];
   
    //Segmented bar display for adult.
    if (drug.isAdult){
        if (!drug.isOralAdult){
            [adminBarDisplay setEnabled:FALSE forSegmentAtIndex:0];
            self.administration.text = @"";
            self.dose.text = @"";
        }
        else [adminBarDisplay setEnabled:TRUE forSegmentAtIndex:0];
        
        if (!drug.isIVAdult){
            [adminBarDisplay setEnabled:FALSE forSegmentAtIndex:1];
            self.administration.text = @"";
            self.dose.text = @"";
        }
        else [adminBarDisplay setEnabled:TRUE forSegmentAtIndex:1];
        
        if (!drug.isInhaledAdult){
            [adminBarDisplay setEnabled:FALSE forSegmentAtIndex:2];
            self.administration.text = @"";
            self.dose.text = @"";
        }
        else [adminBarDisplay setEnabled:TRUE forSegmentAtIndex:2];
        
        if (!drug.isIMAdult){
            [adminBarDisplay setEnabled:FALSE forSegmentAtIndex:3];
            self.administration.text = @"";
            self.dose.text = @"";
        }
         else [adminBarDisplay setEnabled:TRUE forSegmentAtIndex:3];
        
        if (!drug.isPRAdult){
            [adminBarDisplay setEnabled:FALSE forSegmentAtIndex:4];
            self.administration.text = @"";
            self.dose.text = @"";
        }
         else [adminBarDisplay setEnabled:TRUE forSegmentAtIndex:4];
        
        if (!drug.isSCAdult){
            [adminBarDisplay setEnabled:FALSE forSegmentAtIndex:5];
            self.administration.text = @"";
            self.dose.text = @"";
        }
         else [adminBarDisplay setEnabled:TRUE forSegmentAtIndex:5];
    }
    //Makes all the text views scroll back to the top now text has been added.
    [_indication scrollRangeToVisible: NSMakeRange(0, 1)];
    [_brandNames scrollRangeToVisible: NSMakeRange(0, 1)];
    [_sideEffects scrollRangeToVisible: NSMakeRange(0, 1)];
    [_interactions scrollRangeToVisible: NSMakeRange(0, 1)];
    [_administration scrollRangeToVisible: NSMakeRange(0, 1)];
    [_dose scrollRangeToVisible: NSMakeRange(0, 1)];
}

//Changes the layout for paediatric setting.
-(void) paedSetting{
    
    NSMutableString *title= [[NSMutableString alloc] init];
    [title appendString:drug.getGenericName];
    [title appendString:@" -Paediatric"];
    self.navigationItem.title = title;
    
    [_paedSwitch setBackgroundColor: [UIColor redColor]];
    [_paedSwitch setTitleColor:[UIColor whiteColor] forState:UIControlStateSelected];
    [_adultSwitch setBackgroundColor :[UIColor whiteColor]];
    [_adultSwitch setTitleColor:[UIColor redColor] forState:UIControlStateNormal];
    
    //Segmented bar display for adult.
    if (drug.isPaediatric){
        if (!drug.isOralPaed){
            [adminBarDisplay setEnabled:FALSE forSegmentAtIndex:0];
            self.administration.text = @"";
            self.dose.text = @"";
        }
        else [adminBarDisplay setEnabled:TRUE forSegmentAtIndex:0];
        
        if (!drug.isIVPaed){
            [adminBarDisplay setEnabled:FALSE forSegmentAtIndex:1];
            self.administration.text = @"";
            self.dose.text = @"";
        }
        else [adminBarDisplay setEnabled:TRUE forSegmentAtIndex:1];
        
        if (!drug.isInhaledPaed){
            [adminBarDisplay setEnabled:FALSE forSegmentAtIndex:2];
            self.administration.text = @"";
            self.dose.text = @"";
        }
        else [adminBarDisplay setEnabled:TRUE forSegmentAtIndex:2];
        
        if (!drug.isIMPaed){
            [adminBarDisplay setEnabled:FALSE forSegmentAtIndex:3];
            self.administration.text = @"";
            self.dose.text = @"";
        }
        else [adminBarDisplay setEnabled:TRUE forSegmentAtIndex:3];
        
        if (!drug.isPRPaed){
            [adminBarDisplay setEnabled:FALSE forSegmentAtIndex:4];
            self.administration.text = @"";
            self.dose.text = @"";
        }
        else [adminBarDisplay setEnabled:TRUE forSegmentAtIndex:4];
        
        if (!drug.isSCPaed){
            [adminBarDisplay setEnabled:FALSE forSegmentAtIndex:5];
            self.administration.text = @"";
            self.dose.text = @"";
        }
        else [adminBarDisplay setEnabled:TRUE forSegmentAtIndex:5];
    }
    //Makes all the text views scroll back to the top now text has been added.
    [_indication scrollRangeToVisible: NSMakeRange(0, 1)];
    [_brandNames scrollRangeToVisible: NSMakeRange(0, 1)];
    [_sideEffects scrollRangeToVisible: NSMakeRange(0, 1)];
    [_interactions scrollRangeToVisible: NSMakeRange(0, 1)];
    [_administration scrollRangeToVisible: NSMakeRange(0, 1)];
    [_dose scrollRangeToVisible: NSMakeRange(0, 1)];

    
}

//Sets the infomation based on which buttons are toggled.
- (void) buttonLogic {
    switch (self.adminBarDisplay.selectedSegmentIndex)
    {
        case 0:
            if ((drug.isOralAdult) && (self.adultSwitch.selected)){
                self.administration.text = drug.getOralAdultAdministration;
                self.dose.text = drug.getOralAdultDose;
            }else if ((drug.isOralPaed) && (self.paedSwitch.selected)){
                self.administration.text = drug.getOralPaedAdministration;
                self.dose.text = drug.getOralPaedDose;
            }
            break;
            
        case 1:
            if ((drug.isIVAdult) && (self.adultSwitch.selected)){
                self.administration.text = drug.getIVAdultAdministration;
                self.dose.text = drug.getIVAdultDose;
            }else if ((drug.isIVPaed) && (self.paedSwitch.selected)){
                self.administration.text = drug.getIVPaedAdministration;
                self.dose.text = drug.getIVPaedDose;
                break;
            }
            
        case 2:
            if ((drug.isInhaledAdult) && (self.adultSwitch.selected)){
                self.administration.text = drug.getInhaledAdultAdministration;
                self.dose.text = drug.getInhaledAdultDose;
            }else if ((drug.isInhaledPaed) && (self.paedSwitch.selected)){
                self.administration.text = drug.getInhaledPaedAdministration;
                self.dose.text = drug.getInhaledPaedDose;
            }
            break;
            
        case 3:
            if ((drug.isIMAdult) && (self.adultSwitch.selected)){
                self.administration.text = drug.getIMAdultAdministration;
                self.dose.text = drug.getIMAdultDose;
            }else if ((drug.isIMPaed) && (self.paedSwitch.selected)){
                self.administration.text = drug.getIMPaedAdministration;
                self.dose.text = drug.getIMPaedDose;
                break;
            }
            
        case 4:
            if ((drug.isPRAdult) && (self.adultSwitch.selected)){
                self.administration.text = drug.getPRAdultAdministration;
                self.dose.text = drug.getPRAdultDose;
            }else if ((drug.isPRPaed) && (self.paedSwitch.selected)){
                self.administration.text = drug.getPRPaedAdministration;
                self.dose.text = drug.getPRPaedDose;
            }
            break;
    
        case 5:
            if ((drug.isSCAdult) && (self.adultSwitch.selected)){
                self.administration.text = drug.getSCAdultAdministration;
                self.dose.text = drug.getSCAdultDose;
            }else if ((drug.isSCPaed) && (self.paedSwitch.selected)){
                self.administration.text = drug.getSCPaedAdministration;
                self.dose.text = drug.getSCPaedDose;
                break;
            }



        default:
            break;
    }
}

//Method of the segmented bar button.
- (IBAction)adminTypeBar:(id)sender {
    [self buttonLogic];
   }

// Method of the button to show adult information for the drug.
- (IBAction)toggleAdult:(id)sender {
    self.adultSwitch.selected = TRUE;
    self.paedSwitch.selected = FALSE;
    [self adultSetting];
    [self buttonLogic];}

//Method to the button to show the paediatric information for the drug.
- (IBAction)togglePaed:(id)sender {
    self.paedSwitch.selected = TRUE;
    self.adultSwitch.selected = FALSE;
    [self paedSetting];
    [self buttonLogic];
}

// Method to populate the view with data based on route of administration.
- (void) fillFields{
   
    self.indication.text = drug.getIndication;
    self.sideEffects.text = drug.getSideEffects;
    
    NSDictionary *interactions = [[NSDictionary alloc]init ];
    interactions = drug.getDrugInteraction;
    NSMutableString *interactionsString = [[NSMutableString alloc]init];
    [interactions enumerateKeysAndObjectsUsingBlock:^(id key, id obj, BOOL *stop) {
        [interactionsString appendFormat:@"%@ : %@\n", key, obj];
    }];
    self.interactions.text = interactionsString;
        if (drug.isOralAdult){
            self.administration.text = drug.getOralAdultAdministration;
            self.dose.text = drug.getOralAdultDose;
        }else{
            self.administration.text = @" ";
            self.dose.text =@" ";
        }
    self.brandNames.text = [drug.getBrandNames componentsJoinedByString:@" "];
    
   
}


//Sends the drug object to the PathogensForDrug view but only shows the pathogens that are treated with that drug.
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    if ([segue.identifier isEqualToString:@"TreatsSegue"]) {
        PathogensForDrugVC *dvc = segue.destinationViewController;
        dvc.drug = drug;
    }
}


@end