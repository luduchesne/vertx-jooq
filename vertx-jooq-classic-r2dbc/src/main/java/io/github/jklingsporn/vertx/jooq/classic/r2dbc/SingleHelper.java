package io.github.jklingsporn.vertx.jooq.classic.r2dbc;

import org.reactivestreams.Publisher;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.vertx.core.Future;
import io.vertx.core.Promise;

public interface SingleHelper {

  static <X> Future<X> toFuture(Publisher<X> publisher) {
    Promise<X> promise = Promise.promise();
    Single.fromPublisher(publisher)
            .subscribe(promise::complete, promise::fail);
    return promise.future();
  }
  static <X> Future<List<X>> flowToFuture(Publisher<X> publisher) {
    Promise<List<X>> promise = Promise.promise();
    Flowable.fromPublisher(publisher)
            .toList()
            .subscribe(promise::complete, promise::fail);
    return promise.future();
  }

  static Future<Void> voidToFuture(Publisher<Void> publisher) {
    Promise<Void> promise = Promise.promise();
    Completable.fromPublisher(publisher)
            .subscribe(promise::complete, promise::fail);
    return promise.future();
  }

  static <X> Future<X> maybeToFuture(Publisher<X> publisher) {
    Promise<X> promise = Promise.promise();
    Maybe.fromPublisher(publisher)
            .subscribe(promise::complete,
                    promise::fail,
                    () -> {
              if(!promise.future().isComplete()){
                promise.complete(null);
              }
                    } );
    return promise.future();
  }


}
