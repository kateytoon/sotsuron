package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void configure(WebSecurity web) {
		//org.springframework.security.web.firewall.RequestRejectedException:
		//The request was rejected because the URL contained a potentially malicious String ";"
		//というエラーログがコンソールに出力されるため、下記を追加
		DefaultHttpFirewall firewall = new DefaultHttpFirewall();
		web.httpFirewall(firewall);
		//セキュリティ設定を無視するリクエスト設定
		//静的リソースに対するアクセスの場合は、Spring Securityのフィルタを通過しないように設定する
		web.ignoring().antMatchers("/css/**");
	}

	/**
	 * SpringSecurityによる認証を設定
	 * @param http HttpSecurityオブジェクト
	 * @throws Exception 例外
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//初期表示画面を表示する際にログイン画面を表示する
		http
		.authorizeRequests()
		.mvcMatchers("/register","/registerStudent","commitRegister").permitAll()
		.and()
		.formLogin()
		//ログイン画面は常にアクセス可能とする
		.loginPage("/login").permitAll()
		//ログインに成功したら検索画面に遷移する
		.defaultSuccessUrl("/")
		.and()
		//ログイン画面のcssファイルとしても共通のdemo.cssを利用するため、
		//src/main/resources/static/cssフォルダ下は常にアクセス可能とする
		.authorizeRequests().antMatchers("/css/**").permitAll()
		.and()      //かつ
		//管理者ユーザー向けのアクセスパスは、管理者権限をもつユーザーのみアクセス可能にする
		//それ以外はログインした全てのユーザーがアクセス可能にする
		.authorizeRequests().mvcMatchers("/teachers/**").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()    //かつ
		//ログアウト時はログイン画面に遷移する
		.logout().logoutSuccessUrl("/login").permitAll()
		.and()    //かつ
		//エラー発生時はエラー画面に遷移する
		.exceptionHandling().accessDeniedPage("/toError");
	}

	@Autowired
	void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception{

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
