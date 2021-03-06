/*
* Copyright (c) 2006-2007 Erin Catto http:
*
* This software is provided 'as-is', without any express or implied
* warranty.  In no event will the authors be held liable for any damages
* arising from the use of this software.
* Permission is granted to anyone to use this software for any purpose,
* including commercial applications, and to alter it and redistribute it
* freely, subject to the following restrictions:
* 1. The origin of this software must not be misrepresented; you must not
* claim that you wrote the original software. If you use this software
* in a product, an acknowledgment in the product documentation would be
* appreciated but is not required.
* 2. Altered source versions must be plainly marked, and must not be
* misrepresented the original software.
* 3. This notice may not be removed or altered from any source distribution.
*/

goog.provide('box2d.ContactPoint');

goog.require('box2d.ContactID');
goog.require('box2d.Vec2');



// We use contact ids to facilitate warm starting.
/**
 @constructor
 */
box2d.ContactPoint = function() {
  // initialize instance variables for references
  this.position = new box2d.Vec2();
  this.id = new box2d.ContactID();

  this.separation = null;
  this.normalImpulse = null;
  this.tangentImpulse = null;
};
