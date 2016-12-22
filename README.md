# Getting Started with LINE Login in Java on Heroku
[![Build Status](https://travis-ci.org/line/line-login-starter.svg?branch=master)](https://travis-ci.org/line/line-login-starter)

## Overview

This guide walks you through the process of implementing LINE Login into a Web server with Spring Boot on Heroku.

## Requirements

 - JDK 1.8 or later
 - Maven 3.0+
 - Git
 - a free [Heroku](https://dashboard.heroku.com/) account

#### Register Your Channel

 - You must register your website as a Channel to use the features on the LINE Platform. For more details, see: [here](https://developers.line.me/web-api/channel-registration)

## Deploy to Heroku with 'Deploy to Heroku' Button

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)

The 'Deploy to Heroku' button enables you to deploy 'LINE Login Sample Application' to Heroku without leaving the web browser, and with little configuration.
For more details, see: [here](https://blog.heroku.com/archives/2014/8/7/heroku-button)

 - Push 'Deploy to Heroku' Button, then you redirect Heroku Page
 - Set Heroku App Name
 - Set below Heroku Config
     - Channel ID :  You can see 'Channel ID' on Basic information page
     - Channel Secret : You can see 'Channel Secret' on Basic information page
     - Redirect URL : https:// + 'heroku App Name' + .herokuapp.com/auth
 - Push 'Deploy For Free' Button, then Heroku start deploying the source on this repo to a new app on your account

#### Fill in 'Redirect URL'

 - You must fill in 'Redirect URL' on the technical configuration page. For more details, see: [here](https://developers.line.me/web-api/technical-configuration)

#### Open LINE Login Page

 - When setup is complete, you can open LINE Login Page(https:// + 'heroku App Name' + .herokuapp.com/) in your browser.

## View logs

#### Install heroku toolbelt and Log in

 - install [this](https://toolbelt.heroku.com/)
 - Log in your Heroku account.
```
$ heroku login
```

#### View logs

 - Clone the source of an existing application from Heroku using Git. For more details, see: [here](https://devcenter.heroku.com/articles/git-clone-heroku-app)
 - fetch logs, use the heroku logs command. For more details, see: [here](https://devcenter.heroku.com/articles/logging#view-logs)

```
$ heroku git:clone -a yourapp
$ heroku logs --tail
```
