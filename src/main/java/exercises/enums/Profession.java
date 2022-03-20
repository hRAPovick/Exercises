package exercises.enums;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 44 профессии.
 */
public enum Profession {
    ARCHITECT,
    AUDITOR,
    BARBER,
    BLOGGER,
    BUYER,
    CEO,
    COMPOSER,
    COSMETOLOGIST,
    DANCER,
    DESIGNER,
    DETECTIVE,
    DEVELOPER,
    DIRECTOR,
    DISTRIBUTOR,
    DOCTOR,
    DRIVER,
    ENGINEER,
    FINANCIER,
    FLORIST,
    GUARD,
    HOUSEKEEPER,
    INSTRUCTOR,
    JOURNALIST,
    JUDGE,
    LAWYER,
    MAILMAN,
    MANAGER,
    MECHANIC,
    OPERATOR,
    PHOTOGRAPHER,
    PRESIDENT,
    REPAIRER,
    RESEARCHER,
    RETAILER,
    SCIENTIST,
    SCULPTOR,
    SECRETARY,
    SELLER,
    SINGER,
    SOFTWARE_SPECIALIST,
    SUPERVISOR,
    SYSTEMS_ADMINISTRATOR,
    SYSTEMS_ANALYST,
    TRADER;

    private static final int PROFESSIONS_AMOUNT = Profession.values().length;

    public static String getRandomStringProfession() {
        return Profession.values()[ThreadLocalRandom.current()
                .nextInt(PROFESSIONS_AMOUNT)].toString();
    }

    public static Profession getRandomProfession() {
        return Profession.values()[ThreadLocalRandom.current()
                .nextInt(PROFESSIONS_AMOUNT)];
    }
}