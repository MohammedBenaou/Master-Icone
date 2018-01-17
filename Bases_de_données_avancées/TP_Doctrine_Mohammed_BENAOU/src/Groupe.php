<?php

use Doctrine\Common\Collections\ArrayCollection;

/**
 * @Entity @Table(name="groupe")
 */

class Groupe {
  /**
	 * @var int
	 * @Id @Column(type="integer") @GeneratedValue
	 */
  protected $id;
  /**
	 * @var string
	 * @Column(type="string")
	 */
  protected $name;
  /**
	 * @var Personne[]
	 * @ManyToMany(targetEntity="Personne", mappedBy="groupes")
	 */
  protected $personnes;

  public function getId() {
		return $this->id;
	}

  public function __construct () {
		$this->personnes = new ArrayCollection();
	}

  public function getName() {
		return $this->name;
	}
  public function setName($name) {
		return $this->name = $name;
	}
  public function getPersonnes() {
    return $this->personnes;
  }
  public function addPersonne(Personne $personne) {
    $this->personnes[] = $personne;
  }
  public function removePersonne(Personne $personne) {
    $this->personnes->removeElement($personne);
  }
}
