<?php
require_once "src/Telephone.php";

use Doctrine\Common\Collections\ArrayCollection;

// src/Type.php

/**
 * @Entity @Table(name="type")
 */

class Type {
  /**
	 * @var int
	 * @Id @Column(type="integer") @GeneratedValue
	 */
  protected $id;
  /**
	 * @var string
	 * @Column(type="string")
	 */
  protected $type;
  /**
	 * @var Telephone[]
	 * @OneToMany(targetEntity="Telephone", mappedBy="type")
	 */
  protected $telephones;

  public function getId() {
		return $this->id;
	}

  public function __construct () {
		$this->telephones = new ArrayCollection();
	}

  public function getType() {
		return $this->type;
	}
  public function setType($type) {
		return $this->type = $type;
	}
  public function addPhone (Telephone $telephone) {
		$this->telephones[] = $telephone;
		$telephone->setType($this);
	}
  public function getPhones () {
    return $this->telephones;
  }
}
