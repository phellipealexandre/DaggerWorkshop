## Dagger Workshop

Repository created to show the benefits of dependency injection in an Android project.
This codebase uses VIPER architecture without any tooling to inject the dependencies...

In the current state of this codebase, we inject the dependencies properly but
all responsability to do that is delegated to the activity.

Given that information, your goal is:
* Uses dagger to inject the dependencies properly
* Creates an Espresso test using a mocked retrofit (injected by dagger)
* Completes the VIPER architecture in featuretwo module and uses dagger to organize it