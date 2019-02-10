## Dagger Workshop

Repository created to show the benefits of dependency injection in an Android project with Dagger2.
This codebase uses VIPER architecture without any tooling to inject the dependencies...

In the current state of this codebase, we inject the dependencies properly but
all responsibility to do that is delegated to the activity.

Given that information, your goal is:
* Uses dagger to inject the dependencies properly in the app: module
* Uses dagger to inject the dependencies properly in the featureTwo: module
* Creates an Espresso test using a mocked Retrofit (injected by Dagger)