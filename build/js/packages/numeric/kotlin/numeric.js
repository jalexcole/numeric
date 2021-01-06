(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'numeric'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'numeric'.");
    }root.numeric = factory(typeof numeric === 'undefined' ? {} : numeric, kotlin);
  }
}(this, function (_, Kotlin) {
  'use strict';
  var contentEquals = Kotlin.arrayEquals;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var arrayListOf = Kotlin.kotlin.collections.arrayListOf_i5x0yv$;
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_287e2$;
  var copyToArray = Kotlin.kotlin.collections.copyToArray;
  var NotImplementedError_init = Kotlin.kotlin.NotImplementedError;
  function ArrayND() {
    this.nDimensionalArray = ArrayList_init();
    this.shape_0 = [];
  }
  ArrayND.prototype.whatIsTheShape_0 = function () {
    return this.shape_0;
  };
  ArrayND.prototype.add_c6c0hc$ = function (b) {
    var tmp$;
    if (contentEquals(this.shape_0, b.whatIsTheShape_0())) {
      var x = ArrayList_init();
      tmp$ = this.nDimensionalArray.size;
      for (var i = 0; i < tmp$; i++) {
        x.add_11rb$(this.nDimensionalArray.get_za3lpa$(i) + b.nDimensionalArray.get_za3lpa$(i));
      }
      return ArrayND_init(copyToArray(x), this.shape_0);
    } else {
      return ArrayND_init([], []);
    }
  };
  ArrayND.prototype.plus_c6c0hc$ = function (other) {
    return this.add_c6c0hc$(other);
  };
  ArrayND.prototype.print = function () {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'Work in more than one dimension');
  };
  ArrayND.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ArrayND',
    interfaces: []
  };
  function ArrayND_init(ndArray, shape, $this) {
    $this = $this || Object.create(ArrayND.prototype);
    ArrayND.call($this);
    $this.nDimensionalArray = arrayListOf(ndArray.slice());
    $this.shape_0 = shape;
    return $this;
  }
  function ArrayND_init_0(ndArray, $this) {
    $this = $this || Object.create(ArrayND.prototype);
    ArrayND.call($this);
    $this.nDimensionalArray = arrayListOf(ndArray.slice());
    $this.shape_0 = [ndArray.length];
    return $this;
  }
  function sum($receiver) {
    var tmp$;
    var sum = 0.0;
    tmp$ = $receiver.nDimensionalArray.iterator();
    while (tmp$.hasNext()) {
      var i = tmp$.next();
      sum += i;
    }
    return ArrayND_init([sum], [1]);
  }
  function aRangeOf(count) {
  }
  function array(array) {
    return ArrayND_init(array, [array.length]);
  }
  function arrayList(arrayList) {
  }
  function linspace(start, stop, steps) {
  }
  function exp(array) {
  }
  var package$arrayND = _.arrayND || (_.arrayND = {});
  package$arrayND.ArrayND_init_eac3mw$ = ArrayND_init;
  package$arrayND.ArrayND_init_awc180$ = ArrayND_init_0;
  package$arrayND.ArrayND = ArrayND;
  package$arrayND.sum_mas50h$ = sum;
  var package$numk = _.numk || (_.numk = {});
  package$numk.aRangeOf_za3lpa$ = aRangeOf;
  package$numk.array_awc180$ = array;
  package$numk.arrayList_l8u4bv$ = arrayList;
  package$numk.linspace_syxxoe$ = linspace;
  package$numk.exp_awc180$ = exp;
  Kotlin.defineModule('numeric', _);
  return _;
}));

//# sourceMappingURL=numeric.js.map
