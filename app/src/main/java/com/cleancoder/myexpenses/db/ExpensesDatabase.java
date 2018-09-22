package com.cleancoder.myexpenses.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.cleancoder.myexpenses.AppExecutors;
import com.cleancoder.myexpenses.db.converters.DateConverters;
import com.cleancoder.myexpenses.db.dao.AccountRepositoryContract;
import com.cleancoder.myexpenses.db.dao.CategoryRepositoryContract;
import com.cleancoder.myexpenses.db.dao.RecordRepositoryContract;
import com.cleancoder.myexpenses.db.dao.SubCategoryRepositoryContract;
import com.cleancoder.myexpenses.db.dao.TypeRepositoryContract;
import com.cleancoder.myexpenses.db.dao.UserRepositoryContract;
import com.cleancoder.myexpenses.db.entities.Account;
import com.cleancoder.myexpenses.db.entities.Category;
import com.cleancoder.myexpenses.db.entities.Record;
import com.cleancoder.myexpenses.db.entities.SubCategory;
import com.cleancoder.myexpenses.db.entities.Type;
import com.cleancoder.myexpenses.db.entities.User;

@Database(entities = {User.class, Account.class, Type.class, Category.class, SubCategory.class, Record.class}, version = 1)
@TypeConverters(DateConverters.class)
public abstract class ExpensesDatabase extends RoomDatabase {

    public abstract UserRepositoryContract userRepo();

    public abstract AccountRepositoryContract accountRepo();

    public abstract TypeRepositoryContract typeRepo();

    public abstract CategoryRepositoryContract categoryRepo();

    public abstract SubCategoryRepositoryContract subCategoryRepo();

    public abstract RecordRepositoryContract recordRepo();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile ExpensesDatabase INSTANCE;

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    @VisibleForTesting
    public static final String DATABASE_NAME = "expenses_db";

    public static ExpensesDatabase getDatabase(final Context context, final AppExecutors executors) {
        if (INSTANCE == null) {
            synchronized (ExpensesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = buildDatabase(context.getApplicationContext(), executors);
                    INSTANCE.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return INSTANCE;
    }

    private static ExpensesDatabase buildDatabase(final Context appContext, final AppExecutors executors) {
        return Room.databaseBuilder(appContext, ExpensesDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(() -> {
                            new PopulateDbAsync(INSTANCE).execute();
                            INSTANCE.setDatabaseCreated();
                        });
                    }
                }).build();
    }

    private void updateDatabaseCreated(@NonNull final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

    public LiveData<Boolean> getDatabaseCreated() {
        return mIsDatabaseCreated;
    }

    /**
     * Populate the database in the background.
     * If you want to start with more words, just add them.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final TypeRepositoryContract typeRepo;
        private final CategoryRepositoryContract categoryRepo;
        private final SubCategoryRepositoryContract subCategoryRepo;

        PopulateDbAsync(ExpensesDatabase db) {
            typeRepo = db.typeRepo();
            categoryRepo = db.categoryRepo();
            subCategoryRepo = db.subCategoryRepo();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            Type expense = new Type("EXPENSE", "Expense");
            typeRepo.create(expense);

            homeCategory(expense);

            foodCategory(expense);

            healthCategory(expense);

            transportationCategory(expense);

            petsCategory(expense);

            randomCategory(expense);

            Type income = new Type("INCOME", "Income");
            typeRepo.create(income);

            salaryCategory(income);

            rentCategory(income);

            randomIncomeCategory(income);

            return null;
        }

        private void homeCategory(Type expense){
            Category category = new Category("HOME", "Home", expense);
            categoryRepo.create(category);

            SubCategory subCategory = new SubCategory("ELECTRICALL_BILL", "Electrical Bill", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("WATER_BILL", "Water Bill", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("LOAN", "Loan", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("INSURANCE", "Insurance", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("CONDO_TAX", "Condo Tax", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("MAINTENANCE", "Maintenance", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("FURNITURE", "Furniture", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("APPLIANCES", "Appliances", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("SECURITY", "Security", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("CONSTRUCTION", "Construction", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("COMMUNICATIONS", "Communications", category);
            subCategoryRepo.create(subCategory);
        }

        private void foodCategory(Type expense){
            Category category = new Category("FOOD", "Food", expense);
            categoryRepo.create(category);

            SubCategory subCategory = new SubCategory("MEAL", "Meal", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("GROCERIES", "Groceries", category);
            subCategoryRepo.create(subCategory);
        }

        private void healthCategory(Type expense){
            Category category = new Category("HEALTH", "Health", expense);
            categoryRepo.create(category);

            SubCategory subCategory = new SubCategory("INSURANCE", "Insurance", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("PHARMACY", "Pharmacy", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("DOCTOR_APPOINTMENTS", "Doctor's appointments", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("EXAMS", "Exams", category);
            subCategoryRepo.create(subCategory);
        }

        private void transportationCategory(Type expense){
            Category category = new Category("TRANSPORTATION", "Transportation", expense);
            categoryRepo.create(category);

            SubCategory subCategory = new SubCategory("INSURANCE", "Insurance", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("CAR_LOAN", "Car Loan", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("TAXES", "Taxes", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("FUEL", "FUEL", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("TOLLS", "Tolls", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("MAINTENANCE", "Maintenance", category);
            subCategoryRepo.create(subCategory);
        }

        private void petsCategory(Type expense){
            Category category = new Category("PETS", "Pets", expense);
            categoryRepo.create(category);

            SubCategory subCategory = new SubCategory("INSURANCE", "Insurance", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("REGISTRATION", "Registration", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("VET_APPOINTMENTS", "Vet Appointments", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("FOOD", "Food", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("TREATS", "Treats", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("TOYS", "Toys", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("ACCESSORIES", "Accessories", category);
            subCategoryRepo.create(subCategory);
        }

        private void randomCategory(Type expense){
            Category category = new Category("RANDOM", "Random", expense);
            categoryRepo.create(category);

            SubCategory subCategory = new SubCategory("VACATIONS", "Vacations", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("MOVIES", "Movies", category);
            subCategoryRepo.create(subCategory);
        }

        private void salaryCategory(Type income){
            Category category = new Category("SALARY", "Salary", income);
            categoryRepo.create(category);

            SubCategory subCategory = new SubCategory("COMPANY", "Company", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("PARKING", "Parking", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("EXTRA_HOURS", "Extra Hours", category);
            subCategoryRepo.create(subCategory);
        }

        private void rentCategory(Type income){
            Category category = new Category("RENT", "Rent", income);
            categoryRepo.create(category);

            SubCategory subCategory = new SubCategory("RENT", "Rent", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("TAX_RETURNS", "Tax Returns", category);
            subCategoryRepo.create(subCategory);
        }

        private void randomIncomeCategory(Type income){
            Category category = new Category("RANDOM", "Random", income);
            categoryRepo.create(category);

            SubCategory subCategory = new SubCategory("STOCKS", "Stocks", category);
            subCategoryRepo.create(subCategory);

            subCategory = new SubCategory("BANK_INVESTMENTS", "Bank Investments", category);
            subCategoryRepo.create(subCategory);
        }
    }
}