//
//  Drug.m
//  CFMedApp1
//
//  Created by Matt Watson on 12/02/2015.
//  Copyright (c) 2015 Matthew Watson. All rights reserved.
//

#import "Drug.h"

@implementation Drug


//Methods for the drug object
-(NSString *)getGenericName{
    return genericName;
}

-(void) setGenericName : (NSString*) set{
    genericName = set;
}

-(NSString *)getTypeOfDrug{
    return typeOfDrug;
}
-(void) setTypeofDrug : (NSString*) set{
    typeOfDrug = set;
}


//Administration getters & setters
-(NSString *)getOralAdultAdministration{
    if(oralAdult){
        return oralAdultAdministration;
    }
    else return @"N/A";
}
-(void) setOralAdultAdministration : (NSString*) set{
    oralAdultAdministration = set;
    oralAdult = TRUE;
}
-(NSString *)getIVAdultAdministration{
    if(iVAdult){
        return iVAdultAdministration;
    }
    else return @"N/A";
}
-(void) setIVAdultAdministration : (NSString*) set{
    iVAdultAdministration = set;
    iVAdult = TRUE;
}
-(NSString *)getInhaledAdultAdministration{
    if(inhaledAdult){
        return inhaledAdultAdministration;
    }
    else return @"N/A";
}
-(void) setInhaledAdultAdministration : (NSString*) set{
    inhaledAdultAdministration = set;
    inhaledAdult = TRUE;
}
-(NSString *)getIMAdultAdministration{
    if(iMAdult){
        return iMAdultAdministration;
    }
    else return @"N/A";
}
-(void) setIMAdultAdministration : (NSString*) set{
    iMAdultAdministration = set;
    iMAdult = TRUE;
}
-(NSString *)getPRAdultAdministration{
    if(pRAdult){
        return pRAdultAdministration;
    }
    else return @"N/A";
}
-(void) setPRAdultAdministration : (NSString*) set{
    pRAdultAdministration = set;
    pRAdult = TRUE;
}
-(NSString *)getSCAdultAdministration{
    if(sCAdult){
        return sCAdultAdministration;
    }
    else return @"N/A";
}
-(void) setSCAdultAdministration : (NSString*) set{
    sCAdultAdministration = set;
    sCAdult = TRUE;
}
-(NSString *)getOralPaedAdministration{
    if(oralPaed){
        return oralPaedAdministration;
    }
    else return @"N/A";
}
-(void) setOralPaedAdministration : (NSString*) set{
    oralPaedAdministration = set;
    oralPaed = TRUE;
}
-(NSString *)getIVPaedAdministration{
    if(iVPaed){
        return iVPaedAdministration;
    }
    else return @"N/A";
}
-(void) setIVPaedAdministration : (NSString*) set{
    iVPaedAdministration = set;
    iVPaed = TRUE;
}
-(NSString *)getInhaledPaedAdministration{
    if(inhaledPaed){
        return inhaledPaedAdministration;
    }
    else return @"N/A";
}
-(void) setInhaledPaedAdministration : (NSString*) set{
    inhaledPaedAdministration = set;
    inhaledPaed = TRUE;
}
-(NSString *)getIMPaedAdministration{
    if(iMPaed){
        return iMPaedAdministration;
    }
    else return @"N/A";
}
-(void) setIMPaedAdministration : (NSString*) set{
    iMPaedAdministration = set;
    iMPaed = TRUE;
}
-(NSString *)getPRPaedAdministration{
    if(pRPaed){
        return pRPaedAdministration;
    }
    else return @"N/A";
}
-(void) setPRPaedAdministration : (NSString*) set{
    pRPaedAdministration = set;
    pRPaed = TRUE;
}
-(NSString *)getSCPaedAdministration{
    if(sCPaed){
        return sCPaedAdministration;
    }
    else return @"N/A";
}
-(void) setSCPaedAdministration : (NSString*) set{
    sCPaedAdministration = set;
    sCPaed = TRUE;
}


//Dose getters & setters
-(NSString *)getOralAdultDose{
    if(oralAdult){
        return oralAdultDose;
    }
    else return @"N/A";
}
-(void) setOralAdultDose : (NSString*) set{
    oralAdultDose = set;
    oralAdult = TRUE;
}
-(NSString *)getIVAdultDose{
    if(iVAdult){
        return iVAdultDose;
    }
    else return @"N/A";
}
-(void) setIVAdultDose : (NSString*) set{
    iVAdultDose = set;
    iVAdult = TRUE;
}
-(NSString *)getInhaledAdultDose{
    if(inhaledAdult){
        return inhaledAdultDose;
    }
    else return @"N/A";
}
-(void) setInhaledAdultDose : (NSString*) set{
    inhaledAdultDose = set;
    inhaledAdult = TRUE;
}
-(NSString *)getIMAdultDose{
    if(iMAdult){
        return iMAdultDose;
    }
    else return @"N/A";
}
-(void) setIMAdultDose : (NSString*) set{
    iMAdultDose = set;
    iMAdult = TRUE;
}
-(NSString *)getPRAdultDose{
    if(pRAdult){
        return pRAdultDose;
    }
    else return @"N/A";
}
-(void) setPRAdultDose : (NSString*) set{
    pRAdultDose = set;
    pRAdult = TRUE;
}
-(NSString *)getSCAdultDose{
    if(sCAdult){
        return sCAdultDose;
    }
    else return @"N/A";
}
-(void) setSCAdultDose : (NSString*) set{
    sCAdultDose = set;
    sCAdult = TRUE;
}
-(NSString *)getOralPaedDose{
    if(oralPaed){
        return oralPaedDose;
    }
    else return @"N/A";
}
-(void) setOralPaedDose : (NSString*) set{
    oralPaedDose = set;
    oralPaed = TRUE;
}
-(NSString *)getIVPaedDose{
    if(iVPaed){
        return iVPaedDose;
    }
    else return @"N/A";
}
-(void) setIVPaedDose : (NSString*) set{
    iVPaedDose = set;
    iVPaed = TRUE;
}
-(NSString *)getInhaledPaedDose{
    if(inhaledPaed){
        return inhaledPaedDose;
    }
    else return @"N/A";
}
-(void) setInhaledPaedDose : (NSString*) set{
    inhaledPaedDose = set;
    inhaledPaed = TRUE;
}
-(NSString *)getIMPaedDose{
    if(iMPaed){
        return iMPaedDose;
    }
    else return @"N/A";
}
-(void) setIMPaedDose : (NSString*) set{
    iMPaedDose = set;
    iMPaed = TRUE;
}
-(NSString *)getPRPaedDose{
    if(pRPaed){
        return pRPaedDose;
    }
    else return @"N/A";
}
-(void) setPRPaedDose : (NSString*) set{
    pRPaedDose = set;
    pRPaed = TRUE;
}
-(NSString *)getSCPaedDose{
    if(sCPaed){
        return sCPaedDose;
    }
    else return @"N/A";
}
-(void) setSCPaedDose : (NSString*) set{
    sCPaedDose = set;
    sCPaed = TRUE;
}


-(BOOL)isOralAdult{
    return oralAdult;
}
-(void)setOralAdult : (BOOL) set{
    oralAdult =set;
}
-(BOOL)isIVAdult{
    return iVAdult;
}
-(void)setIVAdult : (BOOL) set{
    iVAdult =set;
}
-(BOOL)isInhaledAdult{
    return inhaledAdult;
}
-(void)setInhaledAdult : (BOOL) set{
    inhaledAdult =set;
}
-(BOOL)isIMAdult{
    return iMAdult;
}
-(void)setIMAdult : (BOOL) set{
    iMAdult =set;
}
-(BOOL)isPRAdult{
    return pRAdult;
}
-(void)setPRAdult : (BOOL) set{
    pRAdult =set;
}
-(BOOL)isSCAdult{
    return sCAdult;
}
-(void)setSCAdult : (BOOL) set{
    sCAdult =set;
}
-(BOOL)isOralPaed{
    return oralPaed;
}
-(void) setOralPaed : (BOOL) set{
    oralPaed = set;
}
-(BOOL)isIVPaed{
    return iVPaed;
}
-(void)setIVPaed:(BOOL) set{
    iVPaed =set;
}
-(BOOL)isInhaledPaed{
    return inhaledPaed;
}
-(void)setInhaledPaed:(BOOL) set{
    inhaledPaed =set;
}
-(BOOL)isIMPaed{
    return iMPaed;
}
-(void)setIMPaed : (BOOL) set{
    iMPaed =set;
}
-(BOOL)isPRPaed{
    return pRPaed;
}
-(void)setPRPaed : (BOOL) set{
    pRPaed =set;
}
-(BOOL)isSCPaed{
    return sCPaed;
}
-(void)setSCPaed : (BOOL) set{
    sCPaed =set;
}
-(BOOL)isAdult{
    return adult;
}
-(void)setAdult : (BOOL) set{
    adult =set;
}
-(BOOL)isPaediatric{
    return paediatric;
}
-(void)setPaediatric:(BOOL) set{
    paediatric = set;
}


-(NSArray *) getBrandNames{
    return brandNames;
}
-(void) setBrandNames: (NSArray*)set{
    brandNames =set;
}
-(NSString *) getIndication{
    return indication;
}
-(void) setIndication : (NSString*) set{
    indication =set;
}
-(NSString *) getSideEffects{
    return sideEffects;
}
-(void) setSideEffects: (NSString*) set{
    sideEffects = set;
}
-(NSDictionary *) getDrugInteraction{
    return drugInteraction;
}
-(void) setDrugInteraction: (NSDictionary*) set{
    drugInteraction = set;
}
-(id)init{
    genericName = [[NSString alloc]init];
    typeOfDrug = [[NSString alloc]init];
    brandNames = [[NSArray alloc]init];
    indication = [[NSString alloc]init];
    sideEffects = [[NSString alloc]init];
    drugInteraction = [[NSDictionary alloc]init];
    oralAdult = false;
    iVAdult = false;
    inhaledAdult = false;
    iMAdult = false;
    pRAdult = false,
    sCAdult = false;
    oralPaed = false;
    iVPaed = false;
    inhaledPaed = false;
    iMPaed = false;
    pRPaed = false,
    sCPaed = false;
    adult = false;
    paediatric = false;
    oralAdultAdministration = [[NSString alloc]init];
    oralAdultDose =[[NSString alloc]init];
    iVAdultAdministration = [[NSString alloc]init];
    iVAdultDose = [[NSString alloc]init];
    inhaledAdultAdministration = [[NSString alloc]init];
    iMAdultAdministration = [[NSString alloc]init];
    pRAdultAdministration = [[NSString alloc]init];
    pRAdultDose =[[NSString alloc]init];
    sCAdultAdministration = [[NSString alloc]init];
    oralPaedAdministration = [[NSString alloc]init];
    oralPaedDose =[[NSString alloc]init];
    iVPaedAdministration = [[NSString alloc]init];
    iVPaedDose =[[NSString alloc]init];
    inhaledPaedAdministration = [[NSString alloc]init];
    iMPaedAdministration = [[NSString alloc]init];
    pRPaedAdministration = [[NSString alloc]init];
    sCPaedAdministration = [[NSString alloc]init];
   
    return self;
}
@end
