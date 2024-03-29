package exercises.enums;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 100 Организаций в алфавитном порядке
 */
public enum Brand {
    ABBOTT_LABORATORIES,
    ABBVIE,
    AIG,
    ALBERTSONS,
    ALLSTATE,
    ALPHABET,
    AMAZON,
    AMERICAN_EXPRESS,
    AMERISOURCEBERGEN,
    ANTHEM,
    APPLE,
    ARCHER_DANIELS_MIDLAND,
    AT_AND_T,
    BANK_OF_AMERICA,
    BERKSHIRE_HATHAWAY,
    BEST_BUY,
    BOEING,
    BRISTOL_MYERS_SQUIBB,
    CAPITAL_ONE_FINANCIAL,
    CARDINAL_HEALTH,
    CATERPILLAR,
    CENTENE,
    CHARTER_COMMUNICATIONS,
    CHEVRON,
    CIGNA,
    CISCO_SYSTEMS,
    CITIGROUP,
    COCA_COLA,
    COMCAST,
    COSTCO_WHOLESALE,
    CVS_HEALTH,
    DEERE,
    DELL_TECHNOLOGIES,
    DOLLAR_GENERAL,
    DOW,
    ENERGY_TRANSFER,
    EXELON,
    EXXON_MOBIL,
    FACEBOOK,
    FANNIE_MAE,
    FEDEX,
    FORD_MOTOR,
    FREDDIE_MAC,
    GENERAL_DYNAMICS,
    GENERAL_ELECTRIC,
    GENERAL_MOTORS,
    GOLDMAN_SACHS_GROUP,
    HCA_HEALTHCARE,
    HOME_DEPOT,
    HONEYWELL_INTERNATIONAL,
    HP,
    HUMANA,
    IBM,
    INTEL,
    JOHNSON_AND_JOHNSON,
    JPMORGAN_CHASE,
    KROGER,
    LIBERTY_MUTUAL_INSURANCE_GROUP,
    LOCKHEED_MARTIN,
    LOWES,
    MARATHON_PETROLEUM,
    MCKESSON,
    MERCK,
    METLIFE,
    MICROSOFT,
    MORGAN_STANLEY,
    NATIONWIDE,
    NEW_YORK_LIFE_INSURANCE,
    NIKE,
    NORTHROP_GRUMMAN,
    NORTHWESTERN_MUTUAL,
    ORACLE,
    PEPSICO,
    PFIZER,
    PHILLIPS_66,
    PROCTER_AND_GAMBLE,
    PROGRESSIVE,
    PRUDENTIAL_FINANCIAL,
    PUBLIX_SUPER_MARKETS,
    RAYTHEON_TECHNOLOGIES,
    STATE_FARM_INSURANCE,
    STONEX_GROUP,
    SYSCO,
    TARGET,
    TESLA,
    THERMO_FISHER_SCIENTIFIC,
    TIAA,
    TJX,
    TRAVELERS,
    TYSON_FOODS,
    UNITEDHEALTH_GROUP,
    UPS,
    USAA,
    VALERO_ENERGY,
    VERIZON_COMMUNICATIONS,
    WALGREENS_BOOTS_ALLIANCE,
    WALMART,
    WALT_DISNEY,
    WELLS_FARGO;

    private static final int COMPANY_AMOUNT = Brand.values().length;

    public static String getRandomStringBrand() {
        return Brand.values()[ThreadLocalRandom.current()
                .nextInt(COMPANY_AMOUNT)].toString();
    }

    public static Brand getRandomBrand() {
        return Brand.values()[ThreadLocalRandom.current()
                .nextInt(COMPANY_AMOUNT)];
    }
}
