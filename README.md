# LINE Login Starter Application
[![Build Status](https://travis-ci.org/line/line-login-starter.svg?branch=master)](https://travis-ci.org/line/line-login-starter)

This is a starter application to help you get started on integrating [LINE Login](https://developers.line.biz/en/docs/line-login/overview/) into a web app or website. This sample Java application demonstrates how you can use LINE Login to let users log in to your app with their LINE accounts and to get user information.

The following instructions describe how to deploy the app on Heroku, view logs, and modify the app for yourself.

## Requirements

- A LINE Login channel with the "WEB" app type. To create a channel, go to [Creating a Channel](https://developers.line.me/web-api/channel-registration) on the LINE Developers site.
- A [Heroku](https://dashboard.heroku.com/) account (free to create)

## Deploy the app on Heroku

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)

With the "Deploy to Heroku" button, you can easily deploy the LINE Login starter application to Heroku from your web browser by following the steps below.

1. Click the **Deploy to Heroku** button to go to the Heroku Dashboard to configure and deploy the app.
2. Enter a Heroku app name (optional).
3. Enter the following Heroku config variables.
    - **Channel ID:** Found in the "Channel settings" page in the [console](https://developers.line.me/console/)
    - **Channel secret:** Found in the "Channel settings" page in the [console](https://developers.line.me/console/)
    - **Callback URL:** https:// + "Heroku app name" + .herokuapp.com/auth
4. Click the **Deploy** button. Heroku then deploys this repository to a new Heroku app on your account.

## Configure your app in the console

Set the callback URL in the "App settings" page of the [LINE Developers console](https://developers.line.me/console/).

## Run the app in a browser

When you successfully log in with your LINE credentials, the app displays your LINE user profile image, display name, and status message. Note that you will be logged in automatically if you are logged in to the LINE app on your iOS or Android device.

1. Go to the URL of your app to open up the LINE Login dialog. `https:// + {Heroku app name} + .herokuapp.com`  
2. Log in to LINE and agree to grant the required permissions to the app


### Try out other features of the starter app
Once you have logged into the app, you can select the following buttons to try out other features of this app.

- Verify the user access token
- Refresh the user access token
- Log out the user (revoke the access token)

## View logs
To get more information, you can check the logs of your app using [Heroku CLI][heroku-cli].

1. Log in to Heroku from the command line

    ```shell
    $ heroku login
    ```

1. View the logs. For more information, see [View logs](https://devcenter.heroku.com/articles/logging#view-logs).

    ```shell
    $ heroku logs --app {Heroku app name} --tail
    ```

## Download and make changes to the starter app

You can download the starter app to your local machine to test and make changes for yourself. You can then deploy the app to a web server of your choice. Here, we'll look at how to make and deploy changes to the Heroku app you created in the previous step.

1. Make sure you have the following installed
    - JDK 1.8 or higher installed
    - Maven 3.0 or higher installed
    - Git

1. Clone this GitHub repository.

    ```shell
    git clone https://github.com/line/line-login-starter.git
    ```

1. `cd` into your Git directory
1. Add a remote for Heroku to your local repository

    ```shell
    $ heroku git:remote -a {Heroku app name}
    ```

1. Make edits and commit changes (optional)

    ```shell
    $ git add .
    $ git commit -m "First commit"
    ```

1. Push changes to Heroku master

    ```shell
    $ git push heroku master
    ```

## Other resources

For more information on how to integrate LINE Login with your existing web app, see [Integrating LINE Login with your web app](https://developers.line.me/en/docs/line-login/web/integrate-line-login/).
