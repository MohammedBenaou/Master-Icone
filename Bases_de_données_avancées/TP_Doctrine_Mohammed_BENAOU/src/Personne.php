<?php

require_once "src/Telephone.php";

use Doctrine\Common\Collections\ArrayCollection;

/**
 * @Entity @Table(name="personne")
 */

class Personne {
	/**
	 * @var int
	 * @Id @Column(type="integer") @GeneratedValue
	 */
	protected $id;
	/**
	 * @var string
	 * @Column(type="string")
	 */
	protected $firstName;
	/**
	 * @var string
	 * @Column(type="string")
	 */
	protected $lastName;
	/**
	 * @var Telephone[]
	 * @OneToMany(targetEntity="Telephone", mappedBy="personne", cascade={"persist", "remove"})
	 */
	protected $telephones;
	/**
   * @ManyToMany(targetEntity="Groupe", inversedBy="personnes")
   */
	protected $groupes;

	public function getId() {
		return $this->id;
	}

	public function __construct () {
		$this->telephones = new ArrayCollection();
		$this->groupes = new ArrayCollection();
	}

	public function addPhone (Telephone $telephone) {
		$this->telephones[] = $telephone;
		$telephone->setPersonne($this);
	}
	public function getPhones () {
    return $this->telephones;
  }
	public function getLastName() {
		return $this->lastName;
	}
	public function setLastName($lastName) {
		return $this->lastName = $lastName;
	}
	public function getFirstName() {
		return $this->firstName;
	}
	public function setFirstName($firstname) {
		return $this->firstName = $firstname;
	}
	public function getGroupe() {
		return $this->groupes;
	}
	public function addGroupe(Groupe $groupe) {
		$this->groupes[] = $groupe;
	}
	public function removeGroupe(Groupe $groupe) {
  	$this->groupes->removeElement($groupe);
	}
}
