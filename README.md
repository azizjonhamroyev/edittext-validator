# edittext-validator
Simple EditText Validator to validate editTexts by categories(email, tel number, zip code and others)
# Download

Add it in your root settings.gradle at the end of repositories:
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven {url 'https://jitpack.io'}
    }
}
```
Add the dependency
```gradle
implementation 'com.github.azizjonhamroyev:edittext-validator:1.0'
```
# Usage
Example:
```kotlin
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val etValidator = EditTextValidator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.clearBtn.setOnClickListener {
            etValidator.clearEditTexts(
                binding.emailAddress,
                binding.firstName,
                binding.ipAdress,
                binding.lastName,
                binding.password,
                binding.reEnterPass,
                binding.telNum,
                binding.userId,
                binding.zipCode,
                binding.year
            )
            etValidator.clearSpinners(binding.spin)
        }

        val adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                arrayOf("<Please select one>", "uz", "en", "ru")
            )
        binding.spin.adapter = adapter

        binding.submitBtn.setOnClickListener {
            etValidator.isSpinnerSelectedItem(binding.spin)
            etValidator.isEmailAddressValid(binding.emailAddress)
            etValidator.isEmpty(binding.firstName)
            etValidator.isIPAddressValid(binding.ipAdress)
            etValidator.isEmpty(binding.lastName)
            etValidator.isEmpty(binding.password)
            etValidator.isMatchReEnteredPassword(binding.password, binding.reEnterPass)
            etValidator.isTelNumberValid(binding.telNum)
            etValidator.isUserIdValid(binding.userId)
            etValidator.isZipCodeValid(binding.zipCode)
            etValidator.isYearValidValid(binding.year)
        }
    }
}
```


