<?php

require_once "src/Personne.php";

require_once "src/Type.php";

// src/Telephone.php

/**
 * @Entity @Table(name="telephone")
 */

class Telephone {
  /**
	 * @var int
	 * @Id @Column(type="integer") @GeneratedValue
	 */
  protected $id;
  /**
	 * @var string
	 * @Column(type="string")
	 */
  protected $numero;
  /**
   * @ManyToOne(targetEntity="Type", inversedBy="telephones")
   */
  protected $type;

  /**
   * @ManyToOne(targetEntity="Personne", inversedBy="telephones")
   */
  protected $personne;

  public function getId() {
		return $this->id;
	}

  public function getNumero() {
		return $this->numero;
	}
	public function setNumero($numero) {
		return $this->numero = $numero;
	}
  public function getType() {
    return $this->type;
  }
  public function setType($type) {
    return $this->type = $type;
  }
  public function getPersonne() {
    return $this->personne;
  }
  public function setPersonne($personne) {
    return $this->personne = $personne;
  }
}
